package beans;

//会員登録者の情報を管理するクラス
public class Member {
    private int memberId; // メンバー管理用ID
    private String userName; // ユーザ名
    private String loginId; // ログインID
    private String loginPass; // パスワード
    private int birthYear; // 生れ年

    // コンストラクタ
    public Member(int memberId, String userName, String loginId,
                            String loginPass, int birthYear) {
        this.memberId = memberId;
        this.userName = userName;
        this.loginId = loginId;
        this.loginPass = loginPass;
        this.birthYear = birthYear;
    }

    public Member(String userName, String loginId, String
                                    loginPass, int birthYear) {
        this.userName = userName;
        this.loginId = loginId;
        this.loginPass = loginPass;
        this.birthYear = birthYear;
    }

    // メソッド
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // 十二支を求める
    public String getZodiac() {
        // 十二支リスト
        // 0=申 1=酉 2=戌 3=亥 4=子 5=丑 6=寅 7=卯 8=辰 9=巳 10=午 11=未
        String[] zodiacList = { "申", "酉", "戌", "亥", "子", "丑",
                                "寅", "卯", "辰", "巳", "牛", "未" };

        // 十二支は西暦を12で割った余りから求めることができる
        int remainder = birthYear % 12;

        return zodiacList[remainder];
    }
}