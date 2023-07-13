package Lmod4_04;

public class Book {
    private int bookNo;         // 書籍番号
    private String title;       // タイトル
    private String author;      // 著者
    private String publisher;   // 出版社
    private int price;          // 価格
    private int stock;          // 在庫数

    // コンストラクタ
    public Book() {
    }

    public Book(int bookNo, String title, String author,
            String publisher, int price, int stock) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.stock = stock;
    }

    // メソッド
    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}