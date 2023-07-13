<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseConfirmEL.jsp</title>
</head>
<body>
<table border="1">
<tr>
<th>受講者名</th>
<td> ${entryData.sei} ${entryData.mei}</td>
</tr>
<tr>
<th>性別</th>
<td> ${entryData.gender}</td>
</tr>
<tr>
<th>郵便番号</th>
<td>${entryData.zip}</td>
</tr>
<tr>
<th>住所</th>
<td> ${entryData.address}</td>
</tr>
</table>
<br><a href="course-entry2.html">戻る</a>
</body>
</html>