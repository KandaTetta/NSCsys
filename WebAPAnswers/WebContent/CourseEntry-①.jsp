<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.EntryData" %>
<!-- JSPの処理 -->
<%
String msg = "登録情報を入力してください"; // レスポンス用のメッセージ
String gender = "";

// リクエストパラメータの取得
request.setCharacterEncoding("UTF-8");
String sei = request.getParameter("name_sei");
String mei = request.getParameter("name_mei");
String genderType = request.getParameter("gender");
String zip = request.getParameter("zip");
String address = request.getParameter("address");

if (sei != null && mei != null && genderType != null &&
        zip != null && address != null &&
        !sei.isEmpty() && !mei.isEmpty() && !genderType.isEmpty() &&
        !zip.isEmpty() && !address.isEmpty()) {

    // 性別確認
    switch(genderType){
    case "male":
        gender ="男性";
        break;

    case "female":
        gender = "女性";
    }

    EntryData data = new EntryData(sei,mei,gender,zip,address);

    // セッションへ登録
    session.setAttribute("entryData", data);

    // レスポンス用のメッセージ更新
    msg = "申込み情報を登録しました";
    msg += "<br><a href=\"CourseConfirm.jsp\">登録情報確認</a><br>";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseEntry.jsp</title>
</head>
<body>
<%=msg %>
<br><a href="course-entry2.html">戻る</a>
</body>
</html>