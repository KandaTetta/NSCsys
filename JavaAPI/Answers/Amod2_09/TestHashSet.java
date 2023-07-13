package Amod2_09;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        // HashSetオブジェクトを生成する
        Set<Goods> set = new HashSet<Goods>();

        // HashSetオブジェクトにGoodsオブジェクトを追加する
        set.add(new Goods("りんご", 150));
        set.add(new Goods("みかん", 500));
        set.add(new Goods("りんご", 150));
        set.add(new Goods("メロン", 800));

        // 拡張for文を用いてHashSetオブジェクトの要素を表示する
        for (Goods goods : set) {
            goods.display();
        }
    }
}