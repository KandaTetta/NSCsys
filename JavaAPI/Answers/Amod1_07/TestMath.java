package Amod1_07;

public class TestMath {
    public static void main(String[] args) {
        // 0～1のランダムな値を生成する
        int coin = (int) (Math.random() * 2);

        // 生成した値に応じて表裏を表示する
        if (coin == 0) {
            System.out.println("表");
        } else {
            System.out.println("裏");
        }
    }
}