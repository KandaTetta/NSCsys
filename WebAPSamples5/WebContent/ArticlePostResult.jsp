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
<h2>投稿結果</h2>

<!-- 投稿結果のメッセージを出力 -->
${articlePostResultMessage}

<br><br><a href="ArticleServlet">メニュー画面へ</a>
</body>
</html>