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

// 申込み情報登録
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
    // 申込情報を登録
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "登録情報を入力してください"; // レスポンス用のメッセージ
        String gender = "";

        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String sei = request.getParameter("name_sei");
        String mei = request.getParameter("name_mei");
        String genderType = request.getParameter("gender");
        String zip = request.getParameter("zip");
        String address = request.getParameter("address");

        if (sei != null && mei != null && genderType != null
                && zip != null && address != null && !sei.isEmpty()
                && !mei.isEmpty() && !genderType.isEmpty()
                && !zip.isEmpty() && !address.isEmpty()) {

            // 性別確認
            switch (genderType) {
            case "male":
                gender = "男性";
                break;

            case "female":
                gender = "女性";
            }

            EntryData data = new EntryData(sei, mei, gender, zip, address);

            // セッションへ登録
            HttpSession session = request.getSession();
            session.setAttribute("entryData", data);

            // レスポンス用のメッセージ更新
            msg = "申込み情報を登録しました";
            msg += "<br><a href=\"ConfirmServlet\">登録情報確認</a><br>";
        }

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
        out.println(msg + "<br>");
        out.print("<a href=\"course-entry.html\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
