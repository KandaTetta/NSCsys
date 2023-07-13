package Lmod1_06;

public class Goods {
    private String name; // 商品名
    private int price; // 単価

    // コンストラクタ
    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 商品名を取得する
    public String getName() {
        return name;
    }

    // 商品名を設定する
    public void setName(String name) {
        this.name = name;
    }

    // 単価を取得する
    public int getPrice() {
        return price;
    }

    // 単価を設定する
    public void setPrice(int price) {
        this.price = price;
    }
}
