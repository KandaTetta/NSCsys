package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Member;
import dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "LoginError.jsp"; // 遷移先

        // リクエストパラメータを取得
        String id = request.getParameter("loginId");
        String pass = request.getParameter("loginPass");

        // ログイン情報の確認
        if (id != null && pass != null && !id.isEmpty() && !pass.isEmpty()) {

            try {
                // データベースの登録情報を検索する
                MemberDAO dao = new MemberDAO();
                Member m = dao.selectMemberByLoginData(id, pass);

                // 検索成功
                if (m != null) {
                    // セッションへ登録（ログイン状態の保持）
                    HttpSession session = request.getSession();
                    session.setAttribute("member", m);

                    nextPage = "Menu.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // フォワード
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GETリクエストでサーブレットが呼び出されたとき
        // ログイン画面へ
        request.getRequestDispatcher("login.html").forward(request, response);
    }
}