package Emod4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowBook {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement("SELECT title, author, price FROM books");

            // SQL文の発行
            ResultSet rs = pst.executeQuery();

            // 結果の表示
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                System.out.println(title + "（" + author + "著）" + price + "円");
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
    }
}