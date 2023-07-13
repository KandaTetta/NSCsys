package Amod2_01;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        // ArrayListオブジェクトを生成する
        List<String> list = new ArrayList<String>();

        // ArrayListオブジェクトに文字列を追加する
        list.add("りんご");
        list.add("みかん");
        list.add("メロン");
        list.add("りんご");

        // 拡張for文を用いてArrayListオブジェクトの要素を表示する
        for (String str : list) {
            System.out.println(str);
        }
    }
}