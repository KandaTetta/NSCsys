package Amod4_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowCustomer {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement("SELECT name, address FROM customers");

            // SQL文の発行
            ResultSet rs = pst.executeQuery();

            // 結果の表示
            while (rs.next()) {
                System.out.println("氏名：" + rs.getString("name"));
                System.out.println("住所：" + rs.getString("address"));
                System.out.println();
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