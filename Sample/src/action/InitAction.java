package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.InitService;

public class InitAction implements Action {

	public String execute(HttpServletRequest req) {
		String nextPage = "Menu.jsp";
		try {
			//サービスを呼び出してマスターを取得(部署のドロップダウンと支社のラジオボタン)
			InitService service = new InitService();
			HashMap<String, HashMap<Integer,String>> masterMap = service.init();
			//マスター情報が取得できない場合は例外を発生させる
			if (masterMap == null) {
				throw new Exception("マスター情報が取得できませんでした。");
			}
			//部署のドロップダウンの情報を取得
			HashMap<Integer, String> deptMap = masterMap.get("deptMap");

			//支社(ダミー)のラジオボタン
			HashMap<Integer, String> branchMap = masterMap.get("branchMap");

			//セッションの取得初めてなので引数はtrue
			HttpSession session = req.getSession(true);
			//セッションにマスターの情報を登録しておく
			session.setAttribute("branchMap", branchMap);
			session.setAttribute("deptMap", deptMap);

		} catch (Exception e) {
			e.printStackTrace();
			//エラーをリクエストに追加
			req.setAttribute("err", e.getMessage());
		}
		return nextPage;
	}
}
