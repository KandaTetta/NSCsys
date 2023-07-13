package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EasyRegisterServlet")
public class EasyRegisterServlet extends HttpServlet {
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
        if (name != null && id != null && pass != null && !name.isEmpty()
                                            && !id.isEmpty() && !pass.isEmpty()) {
            // 画面へ表示するメッセージを指定
            bodyMsg = "入力された会員情報は以下のとおりです。<br><br>";
            bodyMsg += "ユーザ名：" + name + "<br>";
            bodyMsg += "ログインID：" + id + "<br>";
            bodyMsg += "パスワード：" + pass + "<br>";
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
        out.println(bodyMsg); // 登録情報の確認結果
        out.println("</body>");
        out.println("</html>");
    }
}