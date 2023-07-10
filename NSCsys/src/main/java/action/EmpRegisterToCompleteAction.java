package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Emp;
import service.EmpRegisterToCompleteService;

public class EmpRegisterToCompleteAction implements Action {

	public String execute(HttpServletRequest req) {
		//エラーになった場合の遷移先を初期値に指定
		String nextPage = "EmpRegisterForm.jsp";
		try {
			//SessionからEmpオブジェクトを取得
			HttpSession session = req.getSession(false);
			Emp emp = (Emp) session.getAttribute("emp");

			EmpRegisterToCompleteService service = new EmpRegisterToCompleteService();
			boolean bool = service.empRegister(emp);
			if (bool == true) {
				//最後の画面に社員番号を表示したいので、NOのみリクエストへ
				req.setAttribute("empNo",emp.getNo());
				//DBへ登録したらSessionの情報は不要になるので削除
				session.removeAttribute("emp");
			}

			//確認画面を設定
			nextPage = "EmpRegisterComplete.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextPage;
	}
}
