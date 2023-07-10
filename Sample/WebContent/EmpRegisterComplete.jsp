<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>社員登録完了</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<h1>社員登録完了</h1>
	下記の番号で登録しました。
	<br /> 社員番号：
	<c:out value="${requestScope.empNo}"></c:out>
	<br>

	<a href="FrontServlet?CID=0">メニューへ戻る</a>
</body>
</html>