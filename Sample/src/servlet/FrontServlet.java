package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.EmpRegisterToCompleteAction;
import action.EmpRegisterToConfirmAction;
import action.EmpSearchToDetailAction;
import action.EmpSearchToListAction;
import action.InitAction;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		// 次画面のURLを格納する変数を宣言
		final String defaultPage = "Menu.jsp";
		Action action = null;
		String nextPage = null;
		// 文字エンコーディングを自動判定

		req.setCharacterEncoding("UTF-8");

		// コマンド番号の読み込み
		String cmd = req.getParameter("CID");

		// セッションの取得
		HttpSession session = req.getSession(false);

		//初回リクエストはサーブレット直接起動のためcmdはnullとなる、
		//それを判断材料にして、メニュー画面へ遷移
		if (cmd == null) {
			action = new InitAction();
			//cmdがnullでなく、sessionが切れている場合はセッションtimeout
		} else if (session == null) {
			req.setAttribute("err", "セッションが切れました。");
			nextPage = defaultPage;
		} else {
			//cmdが0の場合もメニューへ
			switch (cmd) {
			case "0":
				// ただの画面遷移の場合はActionは不要、ページの設定のみ
				nextPage = defaultPage;
				break;
			// 100番台は登録機能
			case "100":
				nextPage = "EmpRegisterForm.jsp";
				break;
			case "101":
				action = new EmpRegisterToConfirmAction();
				break;
			case "102":
				action = new EmpRegisterToCompleteAction();
				break;
			// 200番台は検索機能
			case "200":
				nextPage = "EmpSearchList.jsp";
				break;
			case "201":
				action = new EmpSearchToListAction();
				break;
			case "202":
				action = new EmpSearchToDetailAction();
				break;
			}
		}
		if (action != null) {
			nextPage = action.execute(req);
		}
		if (nextPage != null) {
			// 次画面にリクエストをフォワード
			RequestDispatcher rd = req.getRequestDispatcher(nextPage);
			rd.forward(req, res);
		}
	}
}
