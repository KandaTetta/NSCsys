package Amod1_08;

public class TestDouble {
    public static void main(String[] args) {
        // コマンドライン引数の個数を調べる
        if (args.length != 2) {
            System.err.println("使用方法:>java TestDouble 小数 小数");
            System.exit(1);
        }

        // コマンドライン引数をdouble型に変換する
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        // 掛け算をする
        double result1 = num1 * num2;
        // 割り算をする
        double result2 = num1 / num2;

        // 結果を表示する
        System.out.println(num1 + " * " + num2 + " = " + result1);
        System.out.println(num1 + " / " + num2 + " = " + result2);
    }
}