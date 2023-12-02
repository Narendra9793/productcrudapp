<html>
<head>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
</head>
<body>
     <div class="container mt-3 ">
          <div class="row">
              <div class="col-md-12">
                  <h1 class="text-center mb-3">Welcome to the Product App</h1>
					<table class="table">
					  <thead class="thead-dark ">
					    <tr>
					      <th scope="col">S.No.</th>
					      <th scope="col">Product Name</th>
					      <th scope="col">Product Description</th>
					      <th scope="col">Product Price</th>
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					    
					       <c:forEach var="p" items="${products }">
					         <tr>
					           <th scope="row">${p.productId}</th>
							    <td>${p.productName }</td>
							   <td>${p.productDescription }</td>
							   <td class="font-weight-bold">&#8377;${p.productPrice }</td>
							   <td><a href="delete-product/${p.productId}"><i class="fa-solid fa-trash" style="color: #030303;"></i></a>
							   <a href="update-product/${p.productId}"><i class="fa-solid fa-pen-nib" style="color: #030303;"></i></a>
							   </td>
							  </tr>
					       </c:forEach>

					    
					  </tbody>
					</table>
				  <div class="container text-center">
                     <a href="add-product" class="btn btn-outLine-success">Add Product</a>

                  </div>
              </div>
          </div>
     </div>
</body>
</html>
