package Amod2_06;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    public static void main(String[] args) {
        // コマンドライン引数の数をチェックする
        if (args.length != 1) {
            System.out.println("使用方法:>java CharCounter 文字列");
            System.exit(1);
        }

        // HashMapオブジェクトを生成する
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // 各文字に対して繰り返し
        for (int i = 0; i < args[0].length(); i++) {
            // 該当の文字の現在のカウントを取得する
            char c = args[0].charAt(i);
            Integer count = map.get(c);

            // その文字が既出か確認する
            if (count == null) {
                // 初登場の場合1を登録する
                map.put(c, 1);
            } else {
                // 既出の場合カウントを1増やす
                count++;
                map.put(c, count);
            }
        }

        // 各文字の登場回数を表示する
        for (char c : map.keySet()) {
            System.out.println(c + " : " + map.get(c));
        }
    }
}