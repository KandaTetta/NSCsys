<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Random" %>

<%--JSP処理 --%>
<%
String item = ""; //ラッキーアイテム

// ランダムにラッキーアイテムを選ぶ
// 0～3の乱数生成
int luck = new Random().nextInt(4);

switch (luck) {
case 0:
    item = "ボールペン";
    break;
case 1:
    item = "ハンカチ";
    break;
case 2:
    item = "腕時計";
    break;
case 3:
    item = "キーホルダー";
    break;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LuckyItem.jsp</title>
</head>
<body>
あなたの今日のラッキーアイテムは<br>
<%=item %>
です！
</body>
</html>