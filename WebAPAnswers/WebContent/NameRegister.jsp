<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP処理 --%>
<%
String msg = "ログイン名を入力してください"; // レスポンス用のメッセージ

// リクエストパラメータの取得
request.setCharacterEncoding("UTF-8");
String loginName = request.getParameter("login_name");

if (loginName != null && !loginName.isEmpty()) {
    // セッションへ登録
    session.setAttribute("name", loginName);

    // レスポンス用のメッセージ更新
    msg = "ログイン名を登録しました";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NameRegister.jsp</title>
</head>
<body>
<%=msg %>
<br><a href="name-input2.html">戻る</a>
</body>
</html>