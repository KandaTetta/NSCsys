package Amod4_03;
public class CreateBook {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("タイトル、著者、出版社、価格、在庫数を入力してください。");
            System.exit(1);
        }

        int price = Integer.parseInt(args[3]);
        int stock = Integer.parseInt(args[4]);

        // DAOクラスをインスタンス化
        BooksDAO dao = new BooksDAO();

        // 新規挿入用のメソッドを呼び出す
        int numberOfRows = dao.insertBook(args[0], args[1], args[2], price, stock);

        System.out.println(numberOfRows + "行挿入されました。");
    }
}