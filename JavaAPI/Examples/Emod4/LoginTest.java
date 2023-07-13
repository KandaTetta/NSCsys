package Emod4;

public class LoginTest {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("ログインID、パスワードを指定してください。");
            System.exit(1);
        }

        // ログイン情報を検索する
        // CustomersDAOインスタンス化
        CustomersDAO dao = new CustomersDAO();

        // 検索
        Customer cust = dao.certify(args[0], args[1]);

        // 顧客オブジェクトが取得できている場合
        if (cust != null) {
            System.out.println("ログインに成功しました。");
        } else {
            System.out.println("ログインに失敗しました。");
            System.out.println("ログインID、パスワードを確認してください。");
        }
    }
}