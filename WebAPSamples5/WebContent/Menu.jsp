<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MoNologue +Plus+</title>
</head>
<body>
<h1>MoNologue +Plus+</h1>
<h3>${member.zodiac}年生まれの ${member.userName}さんがログイン中</h3>
<h2>メニュー</h2>
<a href="ArticleServlet?mID=list">投稿一覧を確認</a><br>
<a href="ArticleServlet?mID=post">新規投稿画面へ</a><br><br>
<a href="ArticleServlet?mID=logout">ログアウトする</a>
</body>
</html>