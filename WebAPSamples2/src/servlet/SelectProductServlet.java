package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {
    /**
     * GETリクエスト用処理
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String product = null;      // 選択した商品の商品名

        // リクエストパラメータを取得する
        String productNo = request.getParameter("product_no");

        // リクエストパラメータの値によって振り分ける
        switch (productNo) {
        case "100":
            product = "洗濯機";
            break;
        case "200":
            product = "冷蔵庫";
            break;
        case "300":
            product = "掃除機";
            break;
        default:
            product = "該当なし";
        }

        // レスポンスの指定
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // レスポンス(HTML)を構築
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>SelectProductServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("選択した商品 : " + product + "<br><br>");
        out.println("<a href='select-product.html'>戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }
}