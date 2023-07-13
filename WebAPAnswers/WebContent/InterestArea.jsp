<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%--JSP処理 --%>
<%
Map<String,String> interestList = new HashMap<String,String>();
interestList.put("economy","経済");
interestList.put("sports","スポーツ");
interestList.put("science","科学");
interestList.put("iot","IoT");
interestList.put("entertainment", "エンタメ");

// リクエストパラメータの文字コード指定
request.setCharacterEncoding("UTF-8");

// リクエストパラメータの取得
String name = request.getParameter("fullName");
String[] interestNumberList = request.getParameterValues("interest");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InterestArea.jsp</title>
</head>
<body>
<%=name %>さん<br>
興味のある分野は<br>
<ul>
<%
// 興味のある分野をリスト表示
for(String param :interestNumberList){
%>
<li><%=interestList.get(param) %>
<%} %>
</ul><br>です
</body>
</html>