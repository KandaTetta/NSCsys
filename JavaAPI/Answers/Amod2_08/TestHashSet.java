package Amod2_08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        // ArrayListオブジェクトを生成する
        List<String> list = new ArrayList<String>();

        // ArrayListオブジェクトに商品名を追加する
        list.add("りんご");
        list.add("みかん");
        list.add("メロン");
        list.add("りんご");

        // 拡張for文を用いてArrayListオブジェクトの要素を表示する
        System.out.println("ArrayList…");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println();

        // ArrayListオブジェクトの全要素を持つHashSetオブジェクトを生成する
        Set<String> set = new HashSet<String>(list);

        // 拡張for文を用いてHashSetオブジェクトの要素を表示する
        System.out.println("HashSet…");
        for (String str : set) {
            System.out.println(str);
        }
    }
}