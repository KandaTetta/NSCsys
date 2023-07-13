package Lmod5_01;

import java.sql.Date;

public class BuyingTransaction {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("書籍番号、仕入数を指定してください。");
            System.exit(1);
        }

        int bookNo = Integer.parseInt(args[0]); // 書籍番号
        int buyingQuantity = Integer.parseInt(args[1]); // 仕入数

        // 仕入日
        Date buyingDate = new Date(System.currentTimeMillis());

        // 仕入トランザクションを実行
        BuyingFunctionDAO dao = new BuyingFunctionDAO();
        boolean result = dao.executeBuying(bookNo, buyingQuantity, buyingDate);

        // 仕入トランザクションの実行結果
        if (result) {
            System.out.println("仕入処理が正常に完了しました。");
        } else {
            System.out.println("最初から仕入処理をやり直してください。");
        }
    }
}