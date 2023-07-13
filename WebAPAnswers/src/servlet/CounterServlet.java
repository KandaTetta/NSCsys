package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
    // カウント回数保持用の変数
    private int count;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // カウントアップ
        count++;

        // レスポンスのコンテンツタイプ（MIMEタイプと文字コード）を設定
        response.setContentType("text/html;charset=UTF-8");

        // レスポンスを返すための出力用キャラクタストリームを獲得
        PrintWriter out = response.getWriter();

        // レスポンスを構築
        out.println("<h2>アクセスカウンター</h2>");
        out.println(count + "回目のアクセスです。");
    }
}
