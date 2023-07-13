package Emod4;

public class Customer {
    private int custNo;         // 顧客番号
    private String loginId;     // ログインID
    private String password;    // パスワード
    private String name;        // 名前
    private String address;     // 住所

    // コンストラクタ
    public Customer(int custNo, String loginId,
            String password, String name, String address) {
        this.custNo = custNo;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    // setter/getter
    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}