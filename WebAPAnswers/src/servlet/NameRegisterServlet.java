package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NameRegisterServlet")
public class NameRegisterServlet extends HttpServlet {
    // ログイン名の登録
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String msg = "ログイン名を入力してください"; // レスポンス用のメッセージ

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String loginName = request.getParameter("login_name");

        if (loginName != null && !loginName.isEmpty()) {
            // セッションへ登録
            HttpSession session = request.getSession();
            session.setAttribute("name", loginName);

            // レスポンス用のメッセージ更新
            msg = "ログイン名を登録しました";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>NameRegisterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(msg + "<br>");
        out.print("<a href=\"name-input.html\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }

    // ログイン名の確認
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String msg = "ログイン名を入力してください"; // レスポンス用のメッセージ
        // セッションを取得
        HttpSession session = request.getSession(false);

        // セッションチェック
        if (session != null) {
            String name = (String) session.getAttribute("name");
            msg = "ログイン名：" + name;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>NameRegisterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(msg + "<br>");
        out.print("<a href=\"name-input.html\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }
}