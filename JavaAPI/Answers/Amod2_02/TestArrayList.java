package Amod2_02;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        // ArrayListオブジェクトを生成する
        List<Goods> list = new ArrayList<Goods>();

        // ArrayListオブジェクトにGoodsオブジェクトを追加する
        list.add(new Goods("りんご", 150));
        list.add(new Goods("りんご", 200));
        list.add(new Goods("みかん", 100));
        list.add(new Goods("りんご", 150));

        // 拡張for文を用いてArrayListオブジェクトの要素を表示する
        for (Goods goods : list) {
            goods.display();
        }
    }
}