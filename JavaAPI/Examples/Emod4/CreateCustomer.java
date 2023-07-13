package Emod4;

public class CreateCustomer {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println(
                    "ログインID、パスワード、氏名、住所を入力してください。");
            System.exit(1);
        }

        // 顧客テーブル用DAOクラスのインスタンス化
        CustomersDAO dao = new CustomersDAO();

        // 新規顧客情報登録
        int numberOfRows = dao.insertCustomer(args[0], args[1], args[2], args[3]);

        System.out.println(numberOfRows + "行挿入されました。");
    }
}