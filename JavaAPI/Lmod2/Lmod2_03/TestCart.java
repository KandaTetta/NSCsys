package Lmod2_03;

public class TestCart {
    public static void main(String[] args) {
        // Cartオブジェクトを生成する
        Cart cart = new Cart("Suzuki");

        // Cartオブジェクトに商品を追加する
        cart.add(new Goods("りんご", 150));
        cart.add(new Goods("りんご", 200));
        cart.add(new Goods("みかん", 500));

        System.out.println();

        // Cartオブジェクトの情報を表示する
        cart.display();
    }
}