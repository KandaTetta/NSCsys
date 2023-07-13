<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductResult.jsp</title>
</head>
<body>
<h1>商品情報検索結果</h1>
<ul>
<li>商品番号：${product.no}
<li>商品名：${product.name}
<li>税抜価格： ${product.price}円
<li>税込価格： ${product.taxInPrice}円
</ul>
</body>
</html>