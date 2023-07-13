package Lmod4_01;

import java.sql.SQLException;
// インポートの追加

public class ShowCustomer {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続


            // PreparedStatementの取得


            // SQL文の発行


            // 結果の表示


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの開放

        }
    }
}