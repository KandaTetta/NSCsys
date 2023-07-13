<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSP処理 -->
<%
// リクエストパラメータの取得
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("fullName");
String color = request.getParameter("color");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FavoriteColor.jsp</title>
</head>
<body>
<%=name %>さん<br>
好きな色は<%=color %>です。
</body>
</html>