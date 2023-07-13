package Amod1_05;

public class TestInteger {
    public static void main(String[] args) {
        // コマンドライン引数の個数を調べる
        if (args.length != 2) {
            System.out.println("使用方法:>java TestInteger 整数値 整数値");
            System.exit(1);
        }

        // コマンドライン引数をint型に変換する
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        // 足し算をする
        int total = num1 + num2;

        // 結果を表示する
        System.out.println(num1 + " + " + num2 + " = " + total);
    }
}
