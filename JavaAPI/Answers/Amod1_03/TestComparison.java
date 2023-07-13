package Amod1_03;

public class TestComparison {
    public static void main(String[] args) {
        // コマンドライン引数の個数を調べる
        if (args.length != 2) {
            System.out.println("使用方法:" + ">java TestComparison 文字列 文字列");
            System.exit(1);
        }

        // 指定した文字列を表示する
        System.out.println("指定された2つの文字列を比較します");
        System.out.println("文字列１：" + args[0]);
        System.out.println("文字列２：" + args[1]);
        System.out.println("2つの文字列は等しい？");

        // 指定した2つの文字列をequalsメソッドで比較する
        if (args[0].equals(args[1])) {
            System.out.println("等しい");
        } else {
            System.out.println("等しくない");
        }
    }
}