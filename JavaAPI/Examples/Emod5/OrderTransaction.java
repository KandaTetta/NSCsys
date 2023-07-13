package Emod5;

import java.sql.Date;

public class OrderTransaction {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("顧客番号、書籍番号、注文数を指定してください。");
            System.exit(1);
        }

        int customerNo = Integer.parseInt(args[0]); // 顧客番号
        int bookNo = Integer.parseInt(args[1]); // 書籍番号
        int orderQuantity = Integer.parseInt(args[2]); // 注文数

        // 注文日
        Date orderDate = new Date(System.currentTimeMillis());

        // 注文トランザクションを実行
        OrderFunctionDAO dao = new OrderFunctionDAO();
        boolean result = dao.executeOrder(customerNo, bookNo,
                orderQuantity, orderDate);

        // 注文トランザクションの実行結果
        if (result) {
            System.out.println("注文処理が正常に完了しました。");
        } else {
            System.out.println("最初から注文処理をやり直してください。");
        }
    }
}