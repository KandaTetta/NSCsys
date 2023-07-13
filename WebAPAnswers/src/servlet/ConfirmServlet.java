package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EntryData;

// 申込み情報確認
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッション情報を取得
        HttpSession session = request.getSession(false);
        EntryData data = (EntryData) session.getAttribute("entryData");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>EntryServlet</title>");
        out.println("</head>");
        out.println("<body>");

        if (data != null) {
            // 登録内容
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>受講者名</th>");
            out.println("<td>" + data.getSei() + data.getMei() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>性別</th>");
            out.println("<td>" + data.getGender() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>郵便番号</th>");
            out.println("<td>" + data.getZip() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>住所</th>");
            out.println("<td>" + data.getAddress() + "</td>");
            out.println("</tr>");
            out.println("</table>");
        } else {
            out.println("登録情報がありません");
        }

        out.print("<a href=\"course-entry.html\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }
}