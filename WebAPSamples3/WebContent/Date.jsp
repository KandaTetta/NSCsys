<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%-- スクリプトレット --%>
<%
  String message = "";

  // 現在日時の取得
  Calendar cal = Calendar.getInstance();
  int hour = cal.get(Calendar.HOUR_OF_DAY);

  //時間によって出力する挨拶を変更する
  if(hour > 17) {
    message = "こんばんは！";
  } else if(hour > 10) {
    message = "こんにちは！";
  } else{
    message = "おはようございます！";
  }
%>

<html>
<head>
<meta charset="UTF-8">
<title>Date.jsp</title>
</head>
<body>
<!-- JSPの処理内容を出力 -->
<%= message %><br>
現在の時刻は、<%= hour %>時
<%= cal.get(Calendar.MINUTE) %>分
<%= cal.get(Calendar.SECOND) %>秒です。
</body>
</html>