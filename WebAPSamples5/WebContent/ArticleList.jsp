<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MoNologue +Plus+</title>
</head>
<body>
<h1>MoNologue +Plus+</h1>
<h3>${member.zodiac}年生まれの ${member.userName}さんがログイン中</h3>
<h2>投稿記事一覧</h2>

<%
// リクエストに登録された投稿記事を取得する
List<Article> articleList = (List<Article>)request.getAttribute("list");

if (articleList != null){
%>

  <table  border="1">
  <tr><th>記事No.</th><th>投稿内容</th></tr>

<%
  // 記事の件数分繰り返す
  for(Article article : articleList){
%>
    <tr><td><%=article.getArticleId() %></td>
        <td><%=article.getContent() %></td></tr>
<%
  } // forの終了
%>
  </table>
<%
}else{
%>
  投稿記事が見つかりませんでした。<br>
<%
} // ifの終了
%>

<br><br><a href="ArticleServlet">メニュー画面へ</a>
</body>
</html>