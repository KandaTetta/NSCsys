package Lmod4_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO {
    // タイトルに検索ワードを含むデータを表示する
    public List<Book> search(String word) {
        List<Book> booksList = new ArrayList<Book>(); // 検索結果（書籍情報）
        Connection con = null;
        PreparedStatement pst = null;


        // ここを実装



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