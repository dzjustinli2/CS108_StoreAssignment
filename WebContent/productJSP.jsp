<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, store.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<title><%= getProduct(request).getName() %></title>
</head>
<body>
<h1 class="text-center"><%= getProduct(request).getName() %></h1>
<small class="text-center"><a href="${pageContext.request.contextPath}/products">all items</a></small>
<img src="${pageContext.request.contextPath}/images/<%= getProduct(request).getImageFile() %>">
<p class="text-center">$<%= getProduct(request).getPrice() %></p>
<form class="form-horizontal text-center" action="show-product" method="post">
	<input type="hidden" name="productID" value="<%= getProduct(request).getId() %>">
	<button type="submit" class="btn btn-success">Add to Cart</button>
</form>
</body>
</html>

<%!
Product getProduct(HttpServletRequest request){
	return (Product)request.getAttribute("product");
}
%>