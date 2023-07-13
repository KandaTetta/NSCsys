package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Member;
import dao.MemberDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "RegisterError.jsp"; // 遷移先
        int year = 0; // 生年
        int res = 0; // 更新件数

        // 入力画面の内容を取得する
        // リクエストパラメータの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータを取得
        String name = request.getParameter("userName");
        String id = request.getParameter("loginId");
        String pass = request.getParameter("loginPass");
        String birthYear = request.getParameter("birthYear");

        // 登録情報の確認
        if (name != null && id != null && pass != null && birthYear != null &&
                !name.isEmpty() && !id.isEmpty() &&
                !pass.isEmpty() && !birthYear.isEmpty()) {

            // 生れ年数値変換
            try {
                year = Integer.parseInt(birthYear);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            try {
                // 会員情報をデータベースへ登録する
                Member m = new Member(name, id, pass, year);

                MemberDAO dao = new MemberDAO();
                res = dao.registerMember(m);

                // 登録成功
                if (res == 1) {
                    nextPage = "Result.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // フォワード
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}