package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Member;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String bodyMsg = ""; // チェック結果

        // リクエストパラメータの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // 入力画面の内容を取得する
        // リクエストパラメータの値を取得
        String name = request.getParameter("userName");
        String id = request.getParameter("loginId");
        String pass = request.getParameter("loginPass");

        // 登録情報の確認
        if (name != null && id != null && pass != null &&
                            !name.isEmpty() && !id.isEmpty() && !pass.isEmpty()) {

            // セッションへ新規会員登録の情報を保持するオブジェクトを生成
            Member m = new Member(name, id, pass);

            // セッションオブジェクトを取得する
            HttpSession session = request.getSession();

            // セッションへ登録情報を保存する
            session.setAttribute("member", m);

            // 画面へ表示するメッセージを指定
            bodyMsg = "会員情報を登録しました。<br>";
            bodyMsg += "<a href='ConfirmServlet'>登録情報確認</a>";

        } else {
            bodyMsg = "登録情報をすべて入力してください";
        }

        // レスポンスのコンテンツタイプ（MIMEタイプと文字コード）を設定
        response.setContentType("text/html;charset=UTF-8");

        // レスポンスを返すための出力用キャラクタストリームを獲得
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>MoNologue +Plus+</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>MoNologue +Plus+</h1>");
        out.println(bodyMsg + "<br><br>"); // 登録情報の確認結果
        out.println("<a href='register.html'>登録画面へ</a>");
        out.println("</body>");
        out.println("</html>");
    }
}