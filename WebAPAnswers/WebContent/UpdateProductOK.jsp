<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateProductOK.jsp</title>
</head>
<body>
<h2>商品情報更新</h2>
以下の内容で商品情報を更新しました。<br><br>
<table border="1">
<tr><th>商品番号</th><td>${product.no}</td></tr>
<tr><th>商品名</th><td>${product.name}</td></tr>
<tr><th>価格</th><td>${product.price}</td></tr>
</table>
</body>
</html>