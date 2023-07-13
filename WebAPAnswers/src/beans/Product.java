package beans;

public class Product {
    // 属性
    private int no;         // 商品番号
    private String name;    // 商品名
    private int price;      // 価格

    // コンストラクタ
    public Product() {
    }

    public Product(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    // setter および getter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 税込金額
    public int getTaxInPrice() {
        return (int) (price * 1.08);
    }
}