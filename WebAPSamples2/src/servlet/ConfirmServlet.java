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

@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String bodyMsg = "登録情報が見つかりませんでした"; // メッセージ

        // セッション登録情報を取得する

        // セッションオブジェクトを取得する
        HttpSession session = request.getSession(false);

        // セッションオブジェクトが取得できた場合
        if (session != null) {
            // セッションへ登録されている会員情報を取得する
            Member m = (Member) session.getAttribute("member");

            // 会員情報登録済みの場合
            if (m != null) {
                // 会員情報の詳細を取得し画面へ表示するメッセージを指定
                bodyMsg = "会員情報<br><br>";
                bodyMsg += "ユーザ名：" + m.getUserName() + "<br>";
                bodyMsg += "ログインID：" + m.getLoginId() + "<br>";
                bodyMsg += "パスワード：登録時にご入力されたもの<br>";

                // パスワードの登録情報を確認するためコンソールへ出力する
                System.out.println(m.getLoginPass());
            }
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
        out.println(bodyMsg + "<br><br>"); // 会員情報の詳細
        out.println("<a href=\"login.html\">ログイン画面へ</a>");
        out.println("</body>");
        out.println("</html>");
    }
}