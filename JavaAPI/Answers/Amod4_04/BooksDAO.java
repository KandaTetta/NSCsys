package Amod4_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO {
    // タイトルに検索ワードを含むデータを表示する。
    public List<Book> search(String word) {
        List<Book> booksList = new ArrayList<Book>(); // 検索結果（書籍情報）
        Connection con = null;
        PreparedStatement pst = null;

        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement(
                    "SELECT * FROM books WHERE title LIKE ?");

            // 検索ワードにワイルドカード「%」を付加
            word = "%" + word + "%";

            // パラメータの設定
            pst.setString(1, word);

            // SQL文の発行
            ResultSet rs = pst.executeQuery();

            // 結果の取得
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int price = rs.getInt("price");

                // 書籍情報を保持するオブジェクトを作成
                Book books = new Book();
                books.setTitle(title);
                books.setAuthor(author);
                books.setPublisher(publisher);
                books.setPrice(price);

                // コレクションに追加
                booksList.add(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの開放
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return booksList;
    }

    // 書籍テーブルに新規データを挿入する
    // 戻り値 ： 更新された行数
    public int insertBook(String title, String author,
            String publisher, int price, int stock) {
        int numberOfRows = 0; // 更新された行数

        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement(
                    "INSERT INTO books VALUES(null,?,?,?,?,?)");

            // パラメータの設定
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, publisher);
            pst.setInt(4, price);
            pst.setInt(5, stock);

            // SQL文の発行
            numberOfRows = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの開放
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return numberOfRows;
    }
}