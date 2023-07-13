package Emod5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderFunctionDAO {
    // 書籍データの在庫数から注文数を差し引き、注文データを作成する
    public boolean executeOrder(int customerNo, int bookNo,
            int orderQuantity, Date orderDate) {
        boolean result = false; // 注文処理結果
        int price; // １冊分の価格
        int stock; // 現在の在庫数
        int orderTotal; // 注文の合計金額

        Connection con = null;
        PreparedStatement pst1 = null, pst2 = null, pst3 = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // 自動コミットの無効化
            con.setAutoCommit(false);

            // 書籍テーブルから価格と在庫数を取得
            pst1 = con.prepareStatement(
                    "SELECT price, stock FROM books WHERE book_no = ?");

            pst1.setInt(1, bookNo);
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                price = rs.getInt("price");
                stock = rs.getInt("stock");
            } else {
                throw new SQLException("  エラー：書籍番号が間違っています。");
            }

            // 在庫数のチェック
            if (stock < orderQuantity) {
                throw new SQLException("  エラー：注文数が在庫数を超過しています。");
            }

            // 注文金額の計算
            orderTotal = (int) (orderQuantity * price * 1.08);

            // 在庫数を更新
            pst2 = con.prepareStatement(
                    "UPDATE books SET stock = stock - ? WHERE book_no = ?");

            pst2.setInt(1, orderQuantity);
            pst2.setInt(2, bookNo);
            pst2.executeUpdate();
            System.out.println("在庫数を更新しました。");

            // 注文データの作成
            pst3 = con.prepareStatement(
                    "INSERT INTO orders VALUES(null,?,?,?,?,?)");

            pst3.setInt(1, customerNo);
            pst3.setInt(2, bookNo);
            pst3.setInt(3, orderQuantity);
            pst3.setInt(4, orderTotal);
            pst3.setDate(5, orderDate);
            pst3.executeUpdate();
            System.out.println("注文データを作成しました。");

            // コミットの発行
            con.commit();
            System.out.println("コミットしました。");

            result = true;
        } catch (SQLException e) {
            // ロールバックの発行
            try {
                if (con != null)
                    con.rollback();
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
                if (pst3 != null) {
                    pst3.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }
}