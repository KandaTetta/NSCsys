package Amod2_07;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        // HashSetオブジェクトを生成する
        Set<String> set = new HashSet<String>();

        // セットに文字列を追加する
        set.add("りんご");
        set.add("みかん");
        set.add("メロン");
        set.add("りんご");

        // 拡張for文を用いてセットの要素を表示する
        for (String str : set) {
            System.out.println(str);
        }
    }
}