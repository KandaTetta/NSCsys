package Emod1;
public class TestInteger {
    public static void main(String[] args) {
        // コマンドライン引数のチェック
        if (args.length != 1) {
            System.err.println("使用法：>java TestInteger 数値");
            System.exit(1);
        }

        // コマンドライン引数をint型に変換
        int inputNum = Integer.parseInt(args[0]);

        // 2倍にした結果を出力
        System.out.println("入力値 ：" + inputNum);
        System.out.println("2倍の値：" + (inputNum * 2));

        System.out.println("-------------------------------------");

        // 基本データ型とラッパークラス型の間では、自動的に型変換が行われる
        Integer num1 = 5;
        Integer num2 = 15;

        // Integer型同士の演算が行える
        int num3 = num1 + num2;

        // 結果の出力
        System.out.println(num1 + " + " + num2 + " = " + num3);
    }
}