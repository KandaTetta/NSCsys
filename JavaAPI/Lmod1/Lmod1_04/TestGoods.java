package Lmod1_04;

public class TestGoods {
    public static void main(String[] args) {
        // Goods�I�u�W�F�N�g�𐶐�����
        Goods goods1 = new Goods("���", 150);
        Goods goods2 = new Goods("���", 150);
        Goods goods3 = new Goods("�݂���", 100);

        // display���\�b�h���Ăяo��
        System.out.print("goods1  ");
        goods1.display();
        System.out.print("goods2  ");
        goods2.display();
        System.out.print("goods3  ");
        goods3.display();

        System.out.println();

        // equals���\�b�h��Goods�I�u�W�F�N�g���r����
        System.out.println("goods1��goods2�͓������H");
        if (goods1.equals(goods2)) {
            System.out.println("������");
        } else {
            System.out.println("�������Ȃ�");
        }

        System.out.println();

        // equals���\�b�h��Goods�I�u�W�F�N�g���r����
        System.out.println("goods1��goods3�͓������H");
        if (goods1.equals(goods3)) {
            System.out.println("������");
        } else {
            System.out.println("�������Ȃ�");
        }
    }
}