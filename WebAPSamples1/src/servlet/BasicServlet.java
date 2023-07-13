package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletクラスを継承したBasicServletクラス
 */

@WebServlet("/BasicServlet")    // URL情報
public class BasicServlet extends HttpServlet {
    /**
     * HttpServletクラスのdoGetメソッドをオーバーライド
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>BasicServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("HttpServletクラスを継承して作成したサーブレットです。");
        out.println("</body>");
        out.println("</html>");
    }
}