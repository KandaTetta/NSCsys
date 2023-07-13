<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MoNologue +Plus+</title>
</head>
<body>
<h1>MoNologue +Plus+</h1>
<h3>${member.zodiac}年生まれの ${member.userName}さんがログイン中</h3>
<h2>投稿内容を入力してください</h2>

<form action="ArticleServlet?mId=post" method="POST">
    投稿内容：<br><textarea name="content" rows="4" cols="30" wrap="soft"></textarea><br><br>
    <input type="submit" value="投稿">
    <input type="reset" value="リセット">
</form>
<br><br><a href="ArticleServlet">メニュー画面へ</a>
</body>
</html>