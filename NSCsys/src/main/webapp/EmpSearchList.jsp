<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>社員検索</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>

	<h1>社員検索</h1>
	<form action="FrontServlet" method="GET">
		<table>
			<tr>
				<th>検索ワード</th>
				<th>から～</th>
				<th>～まで</th>
			</tr>
			<tr>
				<td><input type="text" name="word" value="${param.word}"></td>
				<td><input type="date" name="fromDate"
					value="${param.fromDate}"></td>
				<td><input type="date" name="toDate" value="${param.toDate}"></td>
			</tr>
		</table>
		<input type="hidden" name="CID" value="201"> <input
			type="reset" value="リセット"> <input type="submit" value="検索">
	</form>
	<hr>
	<span><c:out value="${err}" /><br /></span>
	<c:if test="${!empty requestScope.list}">

		<table border="1">
			<tr bgcolor="#CCCCCC">
				<th>社員番号</th>
				<th>社員名</th>
				<th>入社日</th>
				<th>部署</th>
			</tr>
			<c:forEach var="emp" items="${requestScope.list}">

				<tr>
					<td><a href="FrontServlet?CID=202&no=${emp.no}" ><c:out value="${emp.no}" /></a></td>
					<td><c:out value="${emp.name}" /></td>
					<td><c:out value="${emp.stringHireDate}" /></td>
					<td><c:out value="${emp.dept.name}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<a href="FrontServlet?CID=0">メニューへ戻る</a>
</body>
</html>