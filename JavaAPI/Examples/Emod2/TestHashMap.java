package Emod2;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        // Stringをキー、値とするマップの生成
        Map<String, String> map = new HashMap<String, String>();

        // マップに値を登録
        map.put("日本", "Japan");
        map.put("アメリカ", "USA");
        map.put("オランダ", "Netherland");

        // キーを指定して値を取得
        System.out.println("日本     : " + map.get("日本"));
        System.out.println("アメリカ : " + map.get("アメリカ"));
        System.out.println("オランダ : " + map.get("オランダ"));

        // すでに存在するキーを指定して追加すると、値の上書き
        map.put("アメリカ", "United States");

        // キーを指定して値を取得
        System.out.println("アメリカ : " + map.get("アメリカ"));
    }
}