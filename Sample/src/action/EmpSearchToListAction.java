package action;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import entity.Emp;
import service.EmpSearchToListService;

public class EmpSearchToListAction implements Action {

	public String execute(HttpServletRequest req) {
		//エラーになった場合の遷移先を初期値に指定
		String nextPage = "EmpSearchList.jsp";
		try {
			// リクエストパラメータの読み込み
			String word = req.getParameter("word");
			String strFromDate = req.getParameter("fromDate");
			Date fromDate = null;
			if (strFromDate !=null && !strFromDate.isEmpty()) {
				//Stringからjava.sql.Date型に変換
				fromDate  = Date.valueOf(strFromDate);
			}
			String strToDate = req.getParameter("toDate");
			Date toDate = null;
			if (strToDate !=null &&!strToDate.isEmpty()) {
				//Stringからjava.sql.Date型に変換
				toDate  = Date.valueOf(strToDate);
			}
			//入力チェックがOKな場合はサービスを呼び出す
			EmpSearchToListService service = new EmpSearchToListService();
			ArrayList<Emp> list = service.findEmpList(word,fromDate,toDate);

			if (list.size()==0) {
				throw new Exception("検索結果０件です");

			}
			//リクエストにEmpオブジェクトを格納
			req.setAttribute("list", list);

			//確認画面を設定
		} catch (Exception e) {
			e.printStackTrace();
			//エラーリストをリクエストに追加
			req.setAttribute("err", e.getMessage());
		}
		return nextPage;
	}
}
