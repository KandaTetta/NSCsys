package Emod2;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        // Stringオブジェクトを扱うArrayListオブジェクトの生成
        List<String> list = new ArrayList<String>();

        // コマンドライン引数をリストに追加
        for (int i = 0; i < args.length; i++) {
            list.add(args[i]);
        }

        // 添え字を使用しリストの中身を表示
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ":" + list.get(i) + " ");
        }
        System.out.println();

        // addメソッドを使用し添え字1の場所に要素を挿入
        list.add(1, "INSERT");

        // 添え字を使用しリストの中身を表示
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ":" + list.get(i) + " ");
        }
        System.out.println();

        // removeメソッドを使用し添え字0の要素を削除
        list.remove(0);

        // 拡張for文で要素を表示
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}