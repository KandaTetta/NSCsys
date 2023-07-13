package beans;

public class Triangle extends Figure{
    private double height; // 高さ
    private double width; // 幅

    // コンストラクタ
    public Triangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // 図形の種類
    public String getKind(){
        return "三角形";
    }

    // 図形面積を計算
    public double getArea() {
        return height * width / 2;
    }
}