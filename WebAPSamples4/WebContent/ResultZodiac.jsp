<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--  MVCのVにあたるJSP --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple +-Conversion-+</title>
</head>
<body>
<h1>Simple +-Conversion-+</h1>

<!--EL式を使って内容を出力 -->
${pData.name}さんへ<br>
${pData.year}年の「十干十二支」を答えます<br><br>

十干：${pData.jikkan}<br>
十二支：${pData.zodiac}<br><br>
<a href="birth-input.html">他の年も調べてみる</a>
</body>
</html>