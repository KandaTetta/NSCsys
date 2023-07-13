package Emod1;

public class TestString {
    public static void main(String[] args) {
        String baseWord = "Hello";
        String inputWord = args[0];     // コマンドライン引数の文字列取得

        System.out.println("入力文字列    : " + inputWord);

        // toString()メソッドを使用して文字列表現を取得
        System.out.println("toString()    : " + inputWord.toString());

        // length()メソッドを使用して文字数を取得
        System.out.println("length()      : " + inputWord.length());

        // charAt(int)メソッドを使用して1文字目を取得
        System.out.println("charAt(0)     : " + inputWord.charAt(0));

        // indexOf(char)メソッドを使用してlAの位置を取得
        System.out.println("indexOf('l')  : " + inputWord.indexOf('l'));

        // == を使用して比較
        System.out.println("==            : " + (baseWord == inputWord));

        // equalsメソッドを使用して比較
        System.out.println("equals        : " + baseWord.equals(inputWord));
    }
}