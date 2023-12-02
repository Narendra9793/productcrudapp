package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
//	Creating or saving a new Product to Database.
	@Transactional
	public void SaveProduct(Product product) {

		this.hibernateTemplate.saveOrUpdate(product);
	}
	
//	Getting a single Product from Database.
	public Product getProduct(int productId) {
		Product product=this.hibernateTemplate.get( Product.class, productId);
		return product;
	}
	
//	Getting multiple Products from Database.
	public List<Product> getProducts() {
		List<Product> products =this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
//	Deleting Product by ProductId from Database.
	@Transactional
	public void deleteProduct(int productId) {
		Product product =this.hibernateTemplate.get(Product.class, productId);
		this.hibernateTemplate.delete(product);
	}


}
