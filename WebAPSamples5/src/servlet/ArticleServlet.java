package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Article;
import beans.Member;
import dao.ArticleDAO;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    // Menu.jspからのリクエストを処理する
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "Menu.jsp"; // 遷移先

        // リクエストパラメータを取得
        String menuId = request.getParameter("mID");

        // メニューIDが取得できた場合
        if (menuId != null) {

            // メニューIDで処理を分岐
            switch (menuId) {
            case "list": // 投稿一覧を確認を選択

                // 投稿記事を取得する

                List<Article> articleList = null;
                try {
                    // DAOクラスを呼び出す（投稿記事を検索する）
                    ArticleDAO dao = new ArticleDAO();

                    // 投稿記事を全件検索する
                    articleList = dao.getAllArticle();

                    if (articleList != null) {
                        // 検索結果をリクエストへ登録
                        request.setAttribute("list", articleList);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // 投稿記事一覧画面へ遷移する
                nextPage = "ArticleList.jsp";
                break;

            case "post":
                // 新規投稿画面へ遷移する
                nextPage = "ArticlePost.jsp";
                break;

            case "logout":
                // ログアウト処理を行う

                // ログインしているユーザ情報を取得
                HttpSession session = request.getSession(false);
                if (session != null) {
                    Member member = (Member) session.getAttribute("member");
                    // セッションを破棄
                    session.invalidate();

                    // ユーザ名をログアウト画面で表示するためにリクエストへ保存
                    request.setAttribute("logoutName", member.getUserName());
                    nextPage = "Logout.jsp";
                }else{
                    nextPage = "login.html";
                }
            }
        }
        // フォワード
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

    // 新規投稿記事を登録する
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "ArticlePostResult.jsp"; // 遷移先
        String msg = "新規投稿に失敗しました"; // 遷移先表示メッセージ

        // 投稿内容を取得する
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("content");

        if (content != null && !content.isEmpty()) {
            // 投稿者の情報を取得する
            HttpSession session = request.getSession(false);
            Member member = (Member) session.getAttribute("member");

            // 登録内容をまとめる
            Article article = new Article();
            article.setContent(content); // 投稿内容
            article.setMemberId(member.getMemberId()); // 投稿者ID

            // DAOクラスを呼び出す（投稿記事を保存する）
            ArticleDAO dao = new ArticleDAO();

            try {
                // 投稿記事を全件検索する
                boolean result = dao.insertArticle(article);

                // 登録成功
                if (result) {
                    msg = "新規投稿が完了しました";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 結果画面へ表示するメッセージを設定
        request.setAttribute("articlePostResultMessage", msg);

        // フォワード
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}