<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-md-6 offset-md-3">
      <h1 class="text-center mb-3">Change product details</h1>
          <form action="${pageContext.request.contextPath}/handle-product" method="post">
              <input type="hidden" value="${product.productId}" name="productId">
              <div class="form-group">
                  <label for="name">Enter the Product Name</label>
                  <input type="text" class="form-control" id="name" name="productName" placeholder="Enter the product name here" value="${product.productName}">
              </div>
              <div class="form-group">
                  <label for="description" >Product Description</label>
                  <textarea class="form-control" name="productDescription" id="productDescription" rows="5" placeholder="Enter the product description" >${product.productDescription}</textarea>
              </div>
              
              <div class="form-group">
                  <label for="price">Product Price</label>
                  <input type="text" class="form-control" id="price" name="productPrice" placeholder="Enter the product price here" value="${product.productPrice}">
              </div>
              <div class="container text-center">
                  <button type="submit" class="btn btn-primary">Update</button>
              </div>
          </form>
    </div>

</div>
</body>
</html>