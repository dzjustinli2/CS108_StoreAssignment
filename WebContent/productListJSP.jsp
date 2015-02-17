<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, store.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<title>Student Store</title>
</head>
<body>

<h1 class="text-center">Student Store</h1>
<small class="text-center"><a href="${pageContext.request.contextPath}/cart">Shopping Cart</a></small>
<br>

<p class="text-center">Items available:</p>

<ul class="text-center">
<% printProducts(request,out); %>
</ul>

</body>
</html>
<%!
void printProducts(HttpServletRequest request, JspWriter out){
	ArrayList<Product> pdAr = (ArrayList<Product>)request.getAttribute("products");
	int size = pdAr.size();
	for(int i = 0; i < size; i++){
		try{
			out.println(getLink(pdAr.get(i))); 
		}catch(Exception e){}
	}
}

String getLink(Product pd){
	return "<li><a href=\"/StoreAssignment/show-product?id="+ pd.getId() +"\">"+ pd.getName() +"</a></li>";
}
%>