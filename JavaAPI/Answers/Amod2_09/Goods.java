package Amod2_09;

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

    // 商品名、単価を表示する
    public void display() {
        System.out.println("商品名:" + name + " 単価:" + price);
    }

    // 等しいオブジェクトかどうかを判定するequalsメソッド
    public boolean equals(Object obj) {
        // 引数のnullチェック 及び 型チェック
        if (obj != null && obj instanceof Goods) {
            // 引数をGoods型に変換
            Goods target = (Goods) obj;

            // 商品名と単価がこのGoodsオブジェクトと等しければtrueを返す
            return (this.name.equals(target.name)) && (this.price == target.price);
        } else {
            // 引数がnull またはGoodsオブジェクトでない場合は
            // falseを返す
            return false;
        }
    }

    // ハッシュコード値を返すhashCodeメソッド
    public int hashCode() {
        // 「商品名:単価」形式の文字列のハッシュコード値を返す
        return (name + ":" + price).hashCode();
    }
}