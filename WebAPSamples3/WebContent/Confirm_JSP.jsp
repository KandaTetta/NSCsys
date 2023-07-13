<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>

 <%-- JSP内の処理（Javaソースコード記述） --%>
 <%
    // セッションへ登録されている会員情報を取得する
    Member m = (Member)session.getAttribute("member");

    //パスワードの登録情報を確認するためコンソールへ出力する
    System.out.println(m.getLoginPass());
%>

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

<!--式タグを使って登録内容を出力 -->
ユーザ名；<%=m.getUserName() %><br>
ログインID：<%=m.getLoginId()  %><br>
パスワード：登録時にご入力されたもの<br>
<br><br>
</body>
</html>