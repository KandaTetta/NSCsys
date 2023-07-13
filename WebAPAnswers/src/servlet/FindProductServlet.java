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

// 商品検索メニューをコントローするサーブレット
@WebServlet("/FindProductServlet")
public class FindProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";
        Product product = null; // 商品オブジェクト
        int productNo = 0; // 商品番号

        // リクエストパラメータを取得
        String no = request.getParameter("productNo");

        // リクエストパラメータが取得できていたらデータベースへ検索を行う
        if (no != null && !no.isEmpty()) {
            try {
                productNo = Integer.parseInt(no);

                // DAOクラスをインスタンス化
                ProductDAO dao = new ProductDAO();

                // 商品を検索
                product = dao.findByProductNo(productNo);

                // 商品情報をリクエストへ登録
                request.setAttribute("product", product);

                // フォワード先を商品表示画面へ設定
                nextPage = "ProductResult.jsp";
            } catch (Exception e) {
                e.printStackTrace();
            }

            // フォワード設定
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);

            // フォワード
            rd.forward(request, response);
        }
    }
}