package action;

import javax.servlet.http.HttpServletRequest;

import entity.Emp;
import service.EmpSearchToDetailService;

public class EmpSearchToDetailAction implements Action {

	public String execute(HttpServletRequest req) {
		//エラーになった場合の遷移先を初期値に指定
		String nextPage = "EmpSearchList.jsp";
		try {
			// リクエストパラメータの読み込み
			int no = Integer.parseInt(req.getParameter("no"));

			//サービスを呼び出す
			EmpSearchToDetailService service = new EmpSearchToDetailService();
			Emp emp = service.findEmp(no);
			//リストから選択するのでありえないが念のため
			if (emp == null) {
				throw new Exception("該当データが存在しません");
			}
			//requestにEmpオブジェクトを格納
			req.setAttribute("emp", emp);
			//画面を設定
			nextPage = "EmpSearchDetail.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			//エラーリストをリクエストに追加
			req.setAttribute("err", e.getMessage());
		}
		return nextPage;
	}
}
