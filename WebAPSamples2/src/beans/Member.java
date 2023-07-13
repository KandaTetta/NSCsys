package beans;

//会員登録者の情報を管理するクラス
public class Member {
	String userName;	// ユーザ名
	String loginId;		// ログインID
	String loginPass;	// パスワード

	// コンストラクタ
	public Member() {
	}

	public Member(String userName, String loginId, String loginPass) {
		this.userName = userName;
		this.loginId = loginId;
		this.loginPass = loginPass;
	}

	// メソッド
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
}
