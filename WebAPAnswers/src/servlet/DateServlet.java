package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 現在時刻を取得
        Calendar cal = Calendar.getInstance();

        // レスポンスのコンテンツタイプ（MIMEタイプと文字コード）を設定
        response.setContentType("text/html;charset=UTF-8");

        // レスポンスを返すための出力用キャラクタストリームを獲得
        PrintWriter out = response.getWriter();

        // レスポンスを構築
        out.print("現在の時刻は、");
        out.print(cal.get(Calendar.HOUR_OF_DAY) + "時");
        out.print(cal.get(Calendar.MINUTE) + "分");
        out.println(cal.get(Calendar.SECOND) + "秒です");
    }
}