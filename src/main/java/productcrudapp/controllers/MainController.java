package productcrudapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	@Autowired
	ProductDao pdao ;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products=this.pdao.getProducts();
		m.addAttribute("products", products);
		return "index";
	}
//	show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form"; 
	}
	
//	handle add product form
	@RequestMapping(path="/handle-product", method=RequestMethod.POST)
	public RedirectView handleAddproductForm(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);	
		this.pdao.SaveProduct(product);
		RedirectView rv=new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
//	handler to delete a product
	@RequestMapping("/delete-product/{productId}")
	public RedirectView delete(@PathVariable("productId") int productId , HttpServletRequest request) {
		this.pdao.deleteProduct(productId);
		RedirectView rv=new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
	
	@RequestMapping("update-product/{productId}")
	public String updateForm(@PathVariable("productId") int productId , Model m) {
		Product product=this.pdao.getProduct(productId);
		m.addAttribute(product);
		return "update_form";
	}
	

}
