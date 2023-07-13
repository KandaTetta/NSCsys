package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* URLパターンを変更 */
@WebServlet("/ShowMessage")

/*
 * 解答例は、URLパターンのみを変更した、同一名の「HelloServlet.java」を同一パッケージ上に
 * 2つ作成することができないため、「HelloServlet2.java」と名前を変更し、作成しています。
 */
public class HelloServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // レスポンスのコンテンツタイプ（MIMEタイプと文字コード）を設定
        response.setContentType("text/html;charset=UTF-8");

        // レスポンスを返すための出力用キャラクタストリームを獲得
        PrintWriter out = response.getWriter();

        // レスポンスを構築
        out.println("Hello World!");
    }
}