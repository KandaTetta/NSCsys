package Amod2_03;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String name;
    private List<Goods> goodsList;

    // コンストラクタ
    public Cart(String name) {
        this.name = name;
        goodsList = new ArrayList<Goods>();
    }

    // 名前を取得する
    public String getName() {
        return name;
    }

    // カートの中の商品一覧を返す
    public List<Goods> getGoodsList() {
        return goodsList;
    }

    // カートに商品を追加する
    public void add(Goods goods) {
        goodsList.add(goods);
        System.out.println("カートに" + goods.getName() + "を追加しました");
    }

    // 合計金額を取得する
    public int getAmount() {
        int amount = 0;
        for (Goods g : goodsList) {
            amount += g.getPrice();
        }
        return amount;
    }

    // カートの中身を表示する
    public void display() {
        System.out.println("--- " + name + "さんのカート ---");

        // カートの中に商品があるかをチェック
        if (goodsList.isEmpty()) {
            System.out.println("カートは空です。");
        } else {
            for (Goods g : goodsList) {
                g.display();
            }
            System.out.println();
            System.out.println("合計：" + getAmount() + "円");
        }
        System.out.println();
    }
}