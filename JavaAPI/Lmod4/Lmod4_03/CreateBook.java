package Lmod4_03;

public class CreateBook {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("タイトル、著者、出版社、価格、在庫数を入力してください。");
            System.exit(1);
        }

        String title = args[0];
        String author = args[1];
        String publisher = args[2];
        int price = Integer.parseInt(args[3]);
        int stock = Integer.parseInt(args[4]);

        // DAOクラスをインスタンス化


        // 新規挿入用のメソッドを呼び出す


        System.out.println(numberOfRows + "行挿入されました。");
    }
}