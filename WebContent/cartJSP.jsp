<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, store.Product, store.Cart, java.text.NumberFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<title>Shopping Cart</title>
</head>
<body>

<h1 class="text-center">Shopping Cart</h1><br>

<form class="form-horizontal text-center" action="cart" method="post">
	<ul class="text-center">
		<% printCart(session,out); %>
	</ul><br>
	Total: <%= getTotal(session) %> <button type="submit" class="btn btn-success">Update Cart</button>
</form><br>
<p class="text-center"><a href="${pageContext.request.contextPath}/">Continue Shopping</a></p>

</body>
</html>
<%!

String getTotal(HttpSession session){
	Cart cart = (Cart)session.getAttribute("cart");
	ArrayList<Product> cartAr = cart.getProducts();
	int size = cartAr.size();
	double sum = 0.0;
	for(int i = 0; i < size; i++){
		sum = sum + (cartAr.get(i).getPrice())*cart.getQuantity(cartAr.get(i));
	}
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	return formatter.format(sum);
}

void printCart(HttpSession session, JspWriter out){
	Cart cart = (Cart)session.getAttribute("cart");
	ArrayList<Product> cartAr = cart.getProducts();
	int size = cartAr.size();
	for(int i = 0; i < size; i++){
		try{
			out.println(getItem(cartAr.get(i),cart)); 
		}catch(Exception e){}
	}
}

String getItem(Product pd, Cart cart){
	String str = "<li><input type=\"number\" name=\""+ pd.getId() +"\" value=\""+ cart.getQuantity(pd) +"\">";
	str = str + pd.getName() + ", " + pd.getPrice() + "</li>";
	return str;
}
%>