<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.*"%>

<%-- JSP内の処理（Javaソースコード記述） --%>
<%
    String bodyMsg = ""; // チェック結果

    //入力画面の内容を取得する

    //リクエストパラメータの文字コードを設定する
    request.setCharacterEncoding("UTF-8");

    // 入力画面の内容を取得する
    // リクエストパラメータの値を取得
    String name = request.getParameter("userName");
    String id = request.getParameter("loginId");
    String pass = request.getParameter("loginPass");

    //登録情報の確認
    if (name != null && id != null && pass != null &&
            !name.isEmpty() && !id.isEmpty() && !pass.isEmpty()) {

        // 会員登録用の情報を保持するオブジェクトを生成する
        Member m = new Member(name, id, pass);

        // セッションへ登録情報を保存する
        session.setAttribute("member", m);

        //画面へ表示するメッセージを指定
        bodyMsg = "会員情報を登録しました。<br><br>";
        bodyMsg += "<a href='Confirm_JSP.jsp'>登録情報確認</a><br>";
        bodyMsg += "<a href='ConfirmEL_JSP.jsp'>登録情報確認（EL式）</a>";
    } else {
        bodyMsg = "登録情報をすべて入力してください";
    }
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
<%=bodyMsg%>
<br><br><br>
<a href="register.html">登録画面へ</a>
</body>
</html>