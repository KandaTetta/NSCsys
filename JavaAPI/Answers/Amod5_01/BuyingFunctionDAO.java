package Amod5_01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyingFunctionDAO {
    // 書籍データの在庫数に仕入数を足し、仕入データを作成する
    public boolean executeBuying(int bookNo, int buyingQuantity, Date buyingDate) {
        boolean result = false; // 仕入処理結果

        Connection con = null;
        PreparedStatement pst1 = null, pst2 = null;

        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // 自動コミットの無効化
            con.setAutoCommit(false);


            // 在庫数を更新
            pst1 = con.prepareStatement(
                    "UPDATE books SET stock = stock + ? WHERE book_no = ?");

            // プレースホルダの設定
            pst1.setInt(1, buyingQuantity);
            pst1.setInt(2, bookNo);

            // SQL文の発行
            pst1.executeUpdate();

            System.out.println("在庫数を更新しました。");

            // 仕入データの作成
            pst2 = con.prepareStatement("INSERT INTO buyings VALUES(null,?,?,?)");

            // プレースホルダの設定
            pst2.setInt(1, bookNo);
            pst2.setInt(2, buyingQuantity);
            pst2.setDate(3, buyingDate);

            // SQL文の発行
            pst2.executeUpdate();

            System.out.println("仕入データを作成しました。");

            // コミットの発行
            con.commit();

            System.out.println("コミットしました。");

            result = true;

        } catch (SQLException e) {
            // ロールバックの発行
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e2) {
            }
            System.out.println("下記のエラーのためロールバックしました。");
            System.out.println(e.getMessage());

        } finally {
            // リソースの開放
            try {
                if (pst1 != null) {
                    pst1.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (pst2 != null) {
                    pst2.close();
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
        return result;
    }
}