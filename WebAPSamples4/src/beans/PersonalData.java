package beans;

//MVCのMにあたるクラス
public class PersonalData {
    private String name; // 名前
    private int year; // 西暦年

    // コンストラクタ
    public PersonalData(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    // 十干を求める
    public String getJikkan() {
        // 十干リスト
        // 0=庚 1=辛 2=壬 3=癸 4=甲 5=乙 6=丙 7=丁 8=戊 9=己
        String[] jikkanList = { "庚（かのえ）", "辛（かのと）", "壬（みずのえ）",
                "癸（みずのと）", "甲（きのえ）","乙（きのと）",
                "丙（ひのえ）", "丁（ひのと）","戊（つちのえ）", "己（つちのと）" };

        // 十干は西暦を10で割った余りから求めることができる
        int remainder = year % 10;

        return jikkanList[remainder];
    }

    // 十二支を求める
    public String getZodiac() {
        // 十二支リスト
        // 0=申 1=酉 2=戌 3=亥 4=子 5=丑 6=寅 7=卯 8=辰 9=巳 10=午 11=未
        String[] zodiacList = { "申", "酉", "戌", "亥", "子", "丑",
                                "寅", "卯", "辰", "巳", "牛", "未" };

        // 十二支は西暦を12で割った余りから求めることができる
        int remainder = year % 12;

        return zodiacList[remainder];
    }
}