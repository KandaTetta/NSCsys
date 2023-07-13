package Emod2;

import java.util.HashSet;

public class TestHashCode{
    public static void main(String[] args){
        // 同じメッセージをもつBadHashClassオブジェクトを生成
        BadHashClass bad1 = new BadHashClass("BAD");
        BadHashClass bad2 = new BadHashClass("BAD");

        // 生成したオブジェクトをHashSetに追加
        HashSet<BadHashClass> set1 = new HashSet<BadHashClass>();
        set1.add(bad1);
        set1.add(bad2);
        System.out.println(bad1.equals(bad2) + " " + bad1.hashCode() + " "
                                        + bad2.hashCode());

        // HashSetオブジェクトの中身を表示
        System.out.println(set1);

        // 同じメッセージをもつGoodHashClassオブジェクトを生成
        GoodHashClass good1 = new GoodHashClass("GOOD");
        GoodHashClass good2 = new GoodHashClass("GOOD");

        // 生成したオブジェクトをHashSetに追加
        HashSet<GoodHashClass> set2 = new HashSet<GoodHashClass>();
        set2.add(good1);
        set2.add(good2);
        System.out.println(good1.equals(good2) + " " + good1.hashCode() + " "
                                        + good2.hashCode());

        // HashSetオブジェクトの中身を表示
        System.out.println(set2);
    }
}