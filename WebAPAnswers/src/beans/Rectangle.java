package beans;

/*
 *  extends Figureは演習1.5.4にて追記
 *
 */
public class Rectangle extends Figure{
    private double height; // 高さ
    private double width; // 幅

    // コンストラクタ
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /*
     * getkindメソッドは演習1.5.4にて追記
     *
     */

    // 図形の種類
    public String getKind(){
        return "長方形";
    }

    // 図形面積を計算
    public double getArea() {
        return height * width;
    }
}