<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>社員情報詳細</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<h1>社員情報詳細</h1>
	<table border="1">
		<tr>
			<th>社員番号</th>
			<td><c:out value="${requestScope.emp.no}" /></td>
		</tr>
		<tr>
			<th>入社日</th>
			<td><c:out value="${requestScope.emp.stringHireDate}" /></td>
		</tr>
		<tr>
			<th>部署</th>
			<td><c:out value="${requestScope.emp.dept.name}" /></td>
		</tr>
		<tr>
			<th>社員名</th>
			<td><c:out value="${requestScope.emp.name}" /></td>
		</tr>
	</table>

	<a href="FrontServlet?CID=0">メニューへ戻る</a>
</body>
</html>