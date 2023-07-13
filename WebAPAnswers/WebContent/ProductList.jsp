<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,beans.Product"%>

<%
	List<Product> productList =
	        (List<Product>) request.getAttribute("productList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductList.jsp</title>
</head>
<body>
<h2>商品一覧</h2>
<table border=1>
<tr><th>商品番号</th><th>商品名</th><th>税抜価格</th><th>税込価格</th></tr>
<% for (Product p : productList) { %>
<tr><td><%= p.getNo() %></td><td><%= p.getName() %></td>
<td><%= p.getPrice() %>円</td><td><%= p.getTaxInPrice() %>円</td></tr>
<% } %>
</table>
</body>
</html>