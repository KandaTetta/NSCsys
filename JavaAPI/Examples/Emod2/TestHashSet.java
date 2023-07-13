package Emod2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        // Stringオブジェクトを扱うArrayListオブジェクトの生成
        List<String> list = new ArrayList<String>();
        // コマンドライン引数をArrayListオブジェクトに追加
        for (String s : args) {
            list.add(s);
        }
        // ArrayListオブジェクトの中身を表示
        System.out.print("List: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // ArrayListオブジェクトの全要素をもつHashSetオブジェクトの生成
        Set<String> set = new HashSet<String>(list);
        // HashSetオブジェクトの中身を表示
        System.out.print("Set : ");
        for (String str : set) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}