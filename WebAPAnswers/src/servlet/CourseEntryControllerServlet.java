package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EntryData;

@WebServlet("/CourseEntryControllerServlet")
public class CourseEntryControllerServlet extends HttpServlet {

    // 申込情報を登録
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        }

        // 次画面へフォワード
        RequestDispatcher rd =
                    request.getRequestDispatcher("CourseEntryResult.jsp");
        rd.forward(request, response);
    }
}