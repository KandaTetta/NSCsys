package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FavoriteColorServlet")
public class FavoriteColorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの文字コード指定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String name = request.getParameter("fullName");
        String color = request.getParameter("color");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>FavoriteColorServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(name + "さん<br>");
        out.println("好きな色は　" + color + "です。");
        out.println("</body>");
        out.println("</html>");
    }
}