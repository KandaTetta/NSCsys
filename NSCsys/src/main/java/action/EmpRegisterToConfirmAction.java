package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Dept;
import entity.Emp;
import service.EmpRegisterToConfirmService;

public class EmpRegisterToConfirmAction implements Action {

	public String execute(HttpServletRequest req) {
		//エラーになった場合の遷移先を初期値に指定
		String nextPage = "EmpRegisterForm.jsp";
		ArrayList<String> errList = new ArrayList<String>();
		try {
			// リクエストパラメータの読み込み
			//名前の取得
			String name = req.getParameter("name");
			if (name.isEmpty()) {
				errList.add("社員名は必須です。");
				req.setAttribute("Err_name", "社員名は必須です。");
			}
			//入社日の取得
			String strHireDate = req.getParameter("hireDate");
			LocalDate hireDate = null;
			if (strHireDate.isEmpty()) {
				errList.add("入社日は必須です。");
				req.setAttribute("Err_hire_date", "入社日は必須です。");
			} else {
				//StringからLocalDate型に変換
				hireDate = LocalDate.parse(strHireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			//部署noの取得
			int deptNo = Integer.parseInt(req.getParameter("deptNo"));

			//支社no（ダミー）の取得
			String strBranch = req.getParameter("branchNo");
			int branch = 0;
			if (strBranch == null || strBranch.isEmpty()) {
				errList.add("支社名は必須です。");
				req.setAttribute("Err_branchNo", "支社名は必須です。");
			} else {
				branch = Integer.parseInt(strBranch);
			}
			//未入力がある場合は例外をスロー
			if (errList.size() != 0) {
				throw new Exception("０件");

			}
			//入力チェックがOKな場合はサービスを呼び出す
			EmpRegisterToConfirmService service = new EmpRegisterToConfirmService();
			Dept dept = service.findDept(deptNo);
			//リストから選択するのでありえないが念のため
			if (dept == null) {
				errList.add("指定された部署が存在しません。");
				throw new Exception("指定された部署が存在しません。");

			}
			//SessionにEmpオブジェクトを格納
			Emp emp = new Emp(name, hireDate, dept, branch);
			HttpSession session = req.getSession(true);
			session.setAttribute("emp", emp);
			//確認画面を設定
			nextPage = "EmpRegisterConfirm.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			//エラーリストをリクエストに追加
			req.setAttribute("errList", errList);
		}
		return nextPage;
	}
}
