package Amod4_02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomer {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // Statementの取得
            pst = con.prepareStatement(
                    "UPDATE customers SET address = ? WHERE cust_no = ?");

            // プレースホルダの設定
            pst.setString(1, "北海道旭川市");
            pst.setInt(2, 1);

            // SQL文の発行
            int numberOfRows = pst.executeUpdate();

            // 結果の表示
            System.out.println(numberOfRows + "行更新されました。");

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