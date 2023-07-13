package Emod4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateBook {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;

        // コマンドライン引数を取得
        if(args.length != 3){
            System.err.println("書籍情報を指定してください");
            System.exit(1);
        }

        String bookName = args[0];      // 書籍名
        String author = args[1];        // 著者名
        String publisher = args[2];     // 出版社

        // 金額と数量は固定
        int price = 2640;
        int stock = 20;

        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/book_store", "jdbc", "jdbc");

            // PreparedStatementの取得
            pst = con.prepareStatement("INSERT INTO books VALUES (null,?,?,?,?,?)");

            pst.setString(1, bookName); // 書籍名
            pst.setString(2, author); // 著者名
            pst.setString(3, publisher); // 出版社名
            pst.setInt(4, price); // 金額
            pst.setInt(5, stock); // 数量

            // SQL文の発行
            int numberOfRows = pst.executeUpdate();

            // 結果の表示
            System.out.println(numberOfRows + "行挿入されました。");
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
    }
}