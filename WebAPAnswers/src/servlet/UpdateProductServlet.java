package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import dao.ProductDAO;

// 商品更新メニューをコントロールするサーブレット
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";

        // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("productNo");
        String name = request.getParameter("productName");
        String price = request.getParameter("price");

        // Productオブジェクト生成
        if (no != null && name != null && price != null
                && !no.isEmpty() && !name.isEmpty() && !price.isEmpty()) {
            try {
                int productNo = Integer.parseInt(no);
                int productPrice = Integer.parseInt(price);

                Product product = new Product(productNo, name, productPrice);

                // DAOクラスをインスタンス化
                ProductDAO dao = new ProductDAO();

                // 商品情報を更新
                int result = dao.updateProduct(product);

                if (result == 1) {
                    // リクエストへ更新に使った商品情報を登録
                    request.setAttribute("product", product);

                    nextPage = "UpdateProductOK.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // フォワード設定
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);

        // フォワード
        rd.forward(request, response);
    }
}