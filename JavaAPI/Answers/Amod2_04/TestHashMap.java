package Amod2_04;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        // HashMapオブジェクトを生成する
        Map<String,String> map = new HashMap<String, String>();

        // HashMapオブジェクトに文字列を4つ追加する
        map.put("東","East");
        map.put("西","West");
        map.put("南","South");
        map.put("北","North");

        // キーを指定して値を取得する
        System.out.println("北 : " + map.get("北"));
        System.out.println("南 : " + map.get("南"));
        System.out.println("東 : " + map.get("東"));
        System.out.println("西 : " + map.get("西"));
    }
}