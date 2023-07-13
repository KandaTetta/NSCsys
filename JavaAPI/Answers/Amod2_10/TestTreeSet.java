package Amod2_10;

import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        // TreeSetオブジェクトを生成する
        TreeSet<String> set = new TreeSet<String>();

        // TreeSetオブジェクトに値を追加する
        set.add("peach");
        set.add("orange");
        set.add("strawberry");
        set.add("mandarin");
        set.add("cherry");
        set.add("apple");

        // 拡張for文を用いてTreeSetオブジェクトの要素を表示する
        for (String str : set) {
            System.out.println(str);
        }
    }
}