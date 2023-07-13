<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,beans.Course"%>

<%
	List<Course> courseList =
	        (List<Course>) request.getAttribute("courseList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseList.jsp</title>
</head>
<body>

<h2>申込み方法</h2>
<ol>
<li>ご連絡先の入力<br>
以下のフォームへ必要事項を入力し、申込みボタンをクリックしてください。
<li>希望コースの確認<br>後日、申込み希望のコースについての確認をさせていただきます。
<li>受講票発送<br>受講が確定しましたら郵送にて受講票を送付いたします。
</ol>

<form action ="CourseEntryServlet" method="POST">
<table border="1">
<tr>
<th>受講者名</th>
<td>姓<input type="text" name="name_sei">&nbsp;
名<input type="text" name="name_mei"></td>
</tr>
<tr>
<th>性別</th>
<td><input type="radio" name="gender" value="male">男性&nbsp;&nbsp;
<input type="radio" name="gender" value="female">女性</td>
</tr>
<tr>
<th>郵便番号</th>
<td><input type="text" name="zip" maxlength="8">入力：(xxx-xxxx)</td>
</tr>
<tr>
<th>住所</th>
<td><input type="text" name="address" size="70"></td>
</tr>
</table><br>

<h3>対象コース一覧</h3>
<table border=1>
<tr><th>選択</th><th>コース番号</th><th>コース名</th><th>学習期間</th></tr>
<% for (Course c : courseList) { %>
<tr><td><input type="radio" name="courseNo" value=<%=c.getCourseNo() %>>
<td><%= c.getCourseNo() %></td><td><%= c.getCourseName() %></td>
<td><%= c.getTerm() %></td></tr>
<% } %>
</table><br>
<input type="submit" value="申込み">
</form>
</body>
</html>