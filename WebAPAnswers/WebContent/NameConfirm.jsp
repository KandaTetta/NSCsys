<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP処理 --%>
<%
String msg = "ログイン名を入力してください"; // レスポンス用のメッセージ

// セッション情報取得
String name = (String) session.getAttribute("name");

// セッションチェック
if (name != null && !name.isEmpty()) {
    msg = "ログイン名：" + name;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NameConfirm.jsp</title>
</head>
<body>
<%=msg %>
<br><a href="name-input2.html">戻る</a>
</body>
</html>