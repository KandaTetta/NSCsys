package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectProductControllerServlet")
public class SelectProductControllerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";    // フォワード先

        // リクエストパラメータを取得する
        String productNo = request.getParameter("product_no");

        // リクエストパラメータの値によってフォワード先を変更する
        switch (productNo) {
        case "100":
            nextPage = "Product1.jsp";
            break;
        case "200":
            nextPage = "Product2.jsp";
            break;
        case "300":
            nextPage = "Product3.jsp";
            break;
        }

        // フォワード先を設定
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);

        // フォワードする
        rd.forward(request, response);
    }
}