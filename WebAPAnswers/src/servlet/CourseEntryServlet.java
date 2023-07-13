package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import beans.EntryData;
import dao.CourseDAO;
import dao.EntryDAO;

// 研修申込みをコントロールするサーブレット
@WebServlet("/CourseEntryServlet")
public class CourseEntryServlet extends HttpServlet {
    // 研修コース一覧表示処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "CourseEntryError.jsp";
        List<Course> courseList; // 研修コースリスト

        // 全研修コースデータを取得
        CourseDAO dao = new CourseDAO();

        try {
            courseList = dao.findAllCourse();

            // リクエストへ登録
            request.setAttribute("courseList", courseList);

            nextPage = "CourseList.jsp";

        } catch (Exception e) {
            e.printStackTrace();
        }

        // フォワード
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }

    // 研修コース申込み処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "CourseEntryError.jsp";
        String gender = "";

        // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");

        String courseNo = request.getParameter("courseNo");
        String sei = request.getParameter("name_sei");
        String mei = request.getParameter("name_mei");
        String genderType = request.getParameter("gender");
        String zip = request.getParameter("zip");
        String address = request.getParameter("address");

        if (courseNo != null && sei != null && mei != null
                && genderType != null && zip != null && address != null
                && !courseNo.isEmpty() && !sei.isEmpty() && !mei.isEmpty()
                && !genderType.isEmpty() && !zip.isEmpty()
                && !address.isEmpty()) {

            // 性別確認
            switch (genderType) {
            case "male":
                gender = "男性";
                break;

            case "female":
                gender = "女性";
            }

            EntryData entryData = new EntryData(sei, mei, gender, zip, address);

            // EntryDAOをインスタンス化
            EntryDAO eDao = new EntryDAO();

            try {
                // 申込み情報登録
                int result = eDao.insertEntryData(courseNo, entryData);

                if (result == 1) {
                    // 申し込んだコース情報を取得
                    CourseDAO cDao = new CourseDAO();
                    Course course = cDao.findCourseByCourseNo(courseNo);

                    // リクエストへ登録したコース情報と申込み情報を登録
                    request.setAttribute("course", course);
                    request.setAttribute("entryData", entryData);

                    nextPage = "CourseEntryInfo.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // フォワード
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
            rd.forward(request, response);
        }
    }
}