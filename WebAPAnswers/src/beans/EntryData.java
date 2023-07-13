package beans;

public class EntryData {
    String sei ;        // 性
    String mei ;        // 名
    String gender ;     // 性別
    String zip ;        // 郵便番号
    String address ;    // 住所

    //コンストラクタ
    public EntryData(){
    }

    public EntryData(String sei, String mei, String gender,
                    String zip, String address) {
        this.sei = sei;
        this.mei = mei;
        this.gender = gender;
        this.zip = zip;
        this.address = address;
    }

    // setter および getter
    public String getSei() {
        return sei;
    }

    public void setSei(String sei) {
        this.sei = sei;
    }

    public String getMei() {
        return mei;
    }

    public void setMei(String mei) {
        this.mei = mei;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
