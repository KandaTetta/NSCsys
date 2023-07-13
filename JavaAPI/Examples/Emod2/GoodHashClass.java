package Emod2;

// hashCodeメソッドをオーバーライドするクラス
public class GoodHashClass{
    private String message;

    public GoodHashClass(String message){
        this.message = message;
    }

    // 同じメッセージをもつオブジェクトならtrueを返す
    public boolean equals(Object o){
        if(o == null || !(o instanceof GoodHashClass)){
            return false;
        } else {
            GoodHashClass gc = (GoodHashClass)o;
            return message.equals(gc.toString());
        }
    }

    // メッセージのhashCodeを返す
    public int hashCode(){
        return message.hashCode();
    }

    // オブジェクトの文字列表現（メッセージ）を返す
    public String toString(){
        return message;
    }
}
