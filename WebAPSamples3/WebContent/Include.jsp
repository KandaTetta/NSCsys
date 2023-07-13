<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include.jsp</title>
</head>
<body>

<%-- ヘッダーファイルをインクルード--%>
<%@ include file="CommonHeader.jsp" %>

<br><br>

<%-- コンテンツ--%>
<%
         String goods ="";

         // 0～3の乱数生成
         int luck = new Random().nextInt(4);


         switch (luck) {
         case 0:
             goods = "8K対応ホームシアターセット";
             break;
         case 1:
             goods = "アウトドア用ソーラーランプセット";
             break;
         case 2:
             goods = "ドローンホームシアターコンプリートセット";
             break;
         default:
             goods = "サラウンドスピーカーセット";
             break;
         }
%>

<h1>あなたにおすすめの製品は・・・</h1>

 <h2><%=goods %></h2>

<br><br>

<%-- フッターファイルをインクルード--%>
<%@ include file="CommonFooter.jsp" %>

</body>
</html>