package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Article;

// ArticleテーブルへアクセスするDAOクラス
public class ArticleDAO {

    // 投稿記事全件を検索する
    public List<Article> getAllArticle() throws SQLException {
        List<Article> articleList = null; // 投稿記事一覧用

        DataSource source = null; // DataSourceオブジェクト
        InitialContext c = null; // ネーミングサービス接続用
        Connection con = null;
        PreparedStatement st = null;

        // データベースへの接続
        try {
            // ネーミングサービスへ接続
            c = new InitialContext();

            // DataSourceオブジェクトを取得
            source = (DataSource) c.lookup("java:comp/env/jdbc/TestWebDB");

            // DataSourceオブジェクトから接続オブジェクトを取得
            con = source.getConnection();

            // PreparedStatementの取得
            st = con.prepareStatement("SELECT * FROM article");

            // SQL文の発行
            ResultSet rs = st.executeQuery();

            // リスト初期化
            articleList = new ArrayList<Article>();

            // 投稿内容1件ずつ取得
            while (rs.next()) {
                // 記事オブジェクト作成
                int articleId = rs.getInt("article_id");
                String content = rs.getString("content");
                int writerId = rs.getInt("writer_id");

                Article article = new Article(articleId, content, writerId);

                // 記事をリストへ追加
                articleList.add(article);
            }
        } catch (NamingException e) {
            e.printStackTrace();

        } finally {
            // クローズ処理

            // ネーミングサービスの終了
            if (c != null) {
                try {
                    c.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 記事一覧
        return articleList;
    }

    // 投稿記事を登録する
    public boolean insertArticle(Article article) throws SQLException {
        boolean result = false;

        DataSource source = null; // DataSourceオブジェクト
        InitialContext c = null; // ネーミングサービス接続用
        Connection con = null;
        PreparedStatement st = null;

        // データベースへの接続
        try {
            // ネーミングサービスへ接続
            c = new InitialContext();

            // DataSourceオブジェクトを取得
            source = (DataSource) c.lookup("java:comp/env/jdbc/TestWebDB");

            // DataSourceオブジェクトから接続オブジェクトを取得
            con = source.getConnection();

            // PreparedStatementの取得
            st = con.prepareStatement("INSERT INTO article VALUES(null,?,?)");

            // プレースホルダを設定
            st.setString(1, article.getContent()); // 投稿内容
            st.setInt(2, article.getMemberId()); // 投稿者

            // SQL文の発行
            int res = st.executeUpdate();

            // 新規投稿成功
            if (res == 1) {
                result = true;
            }
        } catch (NamingException e) {
            e.printStackTrace();

        } finally {
            // クローズ処理

            // ネーミングサービスの終了
            if (c != null) {
                try {
                    c.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}