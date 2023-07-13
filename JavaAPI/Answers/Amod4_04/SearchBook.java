package Amod4_04;

import java.util.List;

public class SearchBook {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("検索ワードを入力してください。");
            System.exit(1);
        }

        // DAOクラスをインスタンス化
        BooksDAO dao = new BooksDAO();

        // 書籍を検索する
        List<Book> booksList = dao.search(args[0]);

        // 検索結果を表示
        for (Book books : booksList) {
            System.out.println(books.getTitle() +
                    "（" + books.getAuthor() + "著）" + books.getPublisher() + " "
                    + books.getPrice() + "円");
        }
    }
}