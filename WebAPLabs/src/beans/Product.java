package beans;

public class Product {
    // 属性
    private int no;         // 商品番号
    private String name;    // 商品名
    private int price;      // 価格

    // コンストラクタ
    public Product() {
    }

    // setter および getter



    // 税込金額
    public int getTaxInPrice() {
        return (int) (price * 1.08);
    }
}