<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.EntryData" %>
<!-- JSPの処理 -->
<%
// セッション情報取得
EntryData data = (EntryData) session.getAttribute("entryData");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseConfirm.jsp</title>
</head>
<body>

<%
if (data != null){
%>
<table border="1">
<tr>
<th>受講者名</th>
<td><%=data.getSei()%> <%=data.getMei()%> </td>
</tr>
<tr>
<th>性別</th>
<td> <%=data.getGender() %></td>
</tr>
<tr>
<th>郵便番号</th>
<td><%=data.getZip() %></td>
</tr>
<tr>
<th>住所</th>
<td> <%=data.getAddress() %></td>
</tr>
</table>

<%}else{ %>
登録情報がありません
<%} %>
<br><a href="course-entry2.html">戻る</a>
</body>
</html>