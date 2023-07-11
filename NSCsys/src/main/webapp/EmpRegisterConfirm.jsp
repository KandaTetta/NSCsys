<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>社員登録確認</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<h1>社員登録確認</h1>
	以下の内容で登録します。
	<table>
		<tr>
			<td>社員名：</td>
			<td><c:out value="${ sessionScope.emp.name}"></c:out></td>
		</tr>
		<tr>
			<td>入社日：</td>
			<td><c:out value="${sessionScope.emp.stringHireDate}"></c:out></td>
		</tr>
		<tr>
			<td>部署：</td>
			<td><c:out value="${sessionScope.emp.dept.name}"></c:out></td>
		</tr>
		<tr>
			<td>支社(ダミー)：</td>
			<td><c:out value="${sessionScope.emp.branchNo}"></c:out></td>
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td><form action="FrontServlet" method="POST">
					<input type="hidden" name="CID" value="100"> <input
						type="submit" value="戻る">
				</form></td>
			<td><form action="FrontServlet" method="POST">
					<input type="hidden" name="CID" value="102"> <input
						type="submit" value="確定">
				</form></td>
		</tr>
	</table>
	<a href="FrontServlet?CID=0">メニューへ戻る</a>
</body>
</html>