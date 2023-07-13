package Amod1_04;

public class TestGoods {
    public static void main(String[] args) {
        // Goodsオブジェクトを生成する
        Goods goods1 = new Goods("りんご", 150);
        Goods goods2 = new Goods("りんご", 150);
        Goods goods3 = new Goods("りんご", 200);

        // displayメソッドを呼び出す
        System.out.print("goods1  ");
        goods1.display();
        System.out.print("goods2  ");
        goods2.display();
        System.out.print("goods3  ");
        goods3.display();

        System.out.println();

        // equalsメソッドでGoodsオブジェクトを比較する
        System.out.println("goods1とgoods2は等しい？");
        if (goods1.equals(goods2)) {
            System.out.println("等しい");
        } else {
            System.out.println("等しくない");
        }

        System.out.println();

        // equalsメソッドでGoodsオブジェクトを比較する
        System.out.println("goods1とgoods3は等しい？");
        if (goods1.equals(goods3)) {
            System.out.println("等しい");
        } else {
            System.out.println("等しくない");
        }
    }
}