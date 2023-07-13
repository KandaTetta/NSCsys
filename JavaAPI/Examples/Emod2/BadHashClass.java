package Emod2;

// hashCodeをオーバーライドしないクラス
public class BadHashClass{
    private String message;

    public BadHashClass(String message){
        this.message = message;
    }

    // 同じメッセージをもつオブジェクトならtrueを返す
    public boolean equals(Object o){
        if(o == null || !(o instanceof BadHashClass)){
            return false;
        } else {
            BadHashClass bc = (BadHashClass)o;
            return message.equals(bc.toString());
        }
    }

    // オブジェクトの文字列表現（メッセージ）を返す
    public String toString(){
        return message;
    }
}