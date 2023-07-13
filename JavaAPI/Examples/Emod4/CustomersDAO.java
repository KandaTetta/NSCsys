package Emod4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 顧客テーブル用DAOクラス
public class CustomersDAO {
    /* 顧客テーブルに新規データを挿入する
     * 戻り値 更新件数（成功時：1)
     */
    public int insertCustomer(String loginId,
            String password, String name, String address) {
        int numberOfRows = 0; // 更新された行数

        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement(
                    "INSERT INTO customers VALUES(null,?,?,?,?)");

            // パラメータの設定
            pst.setString(1, loginId);
            pst.setString(2, password);
            pst.setString(3, name);
            pst.setString(4, address);

            // SQL文の発行
            numberOfRows = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの開放
            try {
                if (pst != null){
                    pst.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
     // 更新件数を返す
        return numberOfRows;
    }

    /* ログインID、パスワードを用いて認証する
     * 戻り値 ログイン成功時: 顧客オブジェクトの返却
     * ログイン失敗時: null
     */
    public Customer certify(String loginId, String password) {
        Customer cust = null; // 顧客オブジェクト

        Connection con = null;
        PreparedStatement pst = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement(
                    "SELECT * FROM customers WHERE login_id = ? AND password= ?");

            // パラメータの設定
            pst.setString(1, loginId);
            pst.setString(2, password);

            // SQL文の発行
            ResultSet rs = pst.executeQuery();

            // １行検索成功（ユーザ認証成功）
            if (rs.next()) {
                // ユーザ情報を取得し、顧客オブジェクトを生成する
                int custNo = rs.getInt("cust_no");
                String name = rs.getString("name");
                String address = rs.getString("address");

                // 顧客オブジェクト生成
                cust = new Customer(custNo, loginId, password, name, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの開放
            try {
                if (pst != null){
                    pst.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        // 顧客オブジェクトを返す
        return cust;
    }
}