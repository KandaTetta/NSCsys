<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- レスポンス(HTML)を構築 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MoNologue +Plus+</title>
</head>
<body>
<h1>MoNologue +Plus+</h1>
会員情報<br><br>

<!--EL式を使って登録内容を出力 -->
ユーザ名：${sessionScope.member.userName}<br>
ログインID：${member.loginId}<br>
パスワード：登録時にご入力されたもの
<br><br>
</body>
</html>