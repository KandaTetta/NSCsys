package Lmod1_06;

public class Goods {
    private String name; // ���i��
    private int price; // �P��

    // �R���X�g���N�^
    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // ���i�����擾����
    public String getName() {
        return name;
    }

    // ���i����ݒ肷��
    public void setName(String name) {
        this.name = name;
    }

    // �P�����擾����
    public int getPrice() {
        return price;
    }

    // �P����ݒ肷��
    public void setPrice(int price) {
        this.price = price;
    }
}
