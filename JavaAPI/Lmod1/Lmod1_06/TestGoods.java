package Lmod1_06;

public class TestGoods {
    public static void main(String[] args) {
        // Goodsオブジェクトを生成する
        Goods goods1 = new Goods("りんご", 150);
        Goods goods2 = new Goods("ミカン", 100);

        // Goodsオブジェクトの情報を表示する
        System.out.println(goods1);
        System.out.println(goods2);
    }
}
