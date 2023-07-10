<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<span><c:out value ="${requestScope.err }"/></span><br/>
	メニューを選択して下さい
	<br>
	<a href="FrontServlet?CID=100">社員登録</a>
	<br>
	<a href="FrontServlet?CID=200">社員検索</a>

</body>
</html>