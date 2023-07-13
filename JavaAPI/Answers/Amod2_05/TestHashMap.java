package Amod2_05;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        // Stringをキー、Goodsを値とするHashMapオブジェクトを生成する
        Map<String, Goods> map = new HashMap<String, Goods>();

        // HashMapオブジェクトにキーと値を追加する
        map.put("りんご", new Goods("りんご", 150));
        map.put("みかん", new Goods("みかん", 100));
        map.put("メロン", new Goods("メロン", 1000));

        // キー(商品名)を指定して値を取得し表示する
        System.out.print("Key:りんご   Value:");
        map.get("りんご").display();
        System.out.print("Key:みかん   Value:");
        map.get("みかん").display();
        System.out.print("Key:メロン   Value:");
        map.get("メロン").display();
    }
}