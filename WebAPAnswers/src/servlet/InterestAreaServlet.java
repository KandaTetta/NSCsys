package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InterestAreaServlet")
public class InterestAreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        Map<String,String> interestList = new HashMap<String,String>();
        interestList.put("economy","経済");
        interestList.put("sports","スポーツ");
        interestList.put("science","科学");
        interestList.put("iot","IoT");
        interestList.put("entertainment", "エンタメ");

        // リクエストパラメータの文字コード指定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String name = request.getParameter("fullName");
        String[] interestNumberList = request.getParameterValues("interest");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>InterestAreaServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(name + "さん<br>");
        out.println("興味のある分野は<br>");
        out.println("<ul>");

        // 興味のある分野をリスト表示
        for(String param :interestNumberList){
            out.println("<li>" + interestList.get(param));
        }
        out.print("</ul><br>です");
        out.println("</body>");
        out.println("</html>");
    }
}