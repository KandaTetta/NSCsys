package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import dao.ProductDAO;

// 商品全件検索メニューをコントロールするサーブレット
@WebServlet("/FindAllProductServlet")
public class FindAllProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";

        try {
            // DAOクラスをインスタンス化
            ProductDAO dao = new ProductDAO();

            // 全件検索
            List<Product> productList = dao.findAllProducts();

            if (productList != null && productList.size() != 0) {
                // リクエストへ登録
                request.setAttribute("productList", productList);

                nextPage = "ProductList.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // フォワード設定
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);

        // フォワード
        rd.forward(request, response);
    }
}