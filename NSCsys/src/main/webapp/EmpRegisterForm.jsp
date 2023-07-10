<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>社員登録</title>
<style type="text/css">
span {
	color: red;
}
</style>
</head>
<body>
	<c:forEach var="err" items="${requestScope.errList}">
		<span><c:out value="${err}" /><br/></span>
	</c:forEach>
	<h1>社員登録</h1>

	<form action="FrontServlet" method="POST">
		<table>
			<tr>
				<td>社員名：</td>
				<td><input type="text" name="name" maxlength="64"
					value="${param.name != null ? param.name : sessionScope.emp.name}">
					<span><c:out value="${requestScope.Err_name }" /></span></td>
			</tr>
			<tr>
				<td>入社日：</td>
				<td><input type="date" name="hireDate"
					value="${param.hireDate != null ? param.hireDate : sessionScope.emp.hireDate}">
					<span><c:out value="${requestScope.Err_hire_date }" /></span></td>
			</tr>

			<tr>
				<td>部署：</td>
				<td><select name="deptNo">
						<c:forEach var="obj" items="${sessionScope.deptMap}">
							<c:choose>
								<c:when
									test="${(param.deptNo != null ? param.deptNo : sessionScope.emp.dept.no) eq obj.key }">
									<option value="${obj.key}" selected>${obj.value}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.key}">${obj.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td>支社(ダミー)：</td>
				<td><c:forEach var="obj" items="${sessionScope.branchMap}">
						<c:choose>
							<c:when
								test="${(param.branchNo != null ? param.branchNo : sessionScope.emp.branchNo) eq obj.key }">
								<input type="radio" name="branchNo" value="${obj.key}" checked>${obj.value}
						</c:when>
							<c:otherwise>
								<input type="radio" name="branchNo" value="${obj.key}">${obj.value}
						</c:otherwise>
						</c:choose>
					</c:forEach> <span><c:out value="${requestScope.Err_branchNo }" /></span></td>
			</tr>
		</table>
		<br> <input type="hidden" name="CID" value="101"> <input
			type="submit" value="登録"> <input type="reset" value="取り消し">
	</form>
	<a href="FrontServlet?CID=0">メニューへ戻る</a>
</body>
</html>