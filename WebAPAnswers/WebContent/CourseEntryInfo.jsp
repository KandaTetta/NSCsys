<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseEntryInfo.jsp</title>
</head>
<body>
<h2>お申込み情報</h2>

以下の内容で申し込みを承りました。<br>
担当者からのご連絡をお待ちください<br>

<h3>研修コース情報</h3>
<ul>
<li>コース番号：${course.courseNo}
<li>コース名：${course.courseName}
<li>学習期間：${course.term}
</ul>

<h3>お申込者情報</h3>
<ul>
<li>受講者名：${entryData.sei}${entryData.mei}
<li>性別：${entryData.gender}
<li>郵便番号：${entryData.zip}
<li>住所：${entryData.address}
</ul>
</body>
</html>