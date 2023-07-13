package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 商品全件検索メニューをコントロールするサーブレット
@WebServlet("/FindAllProductServlet")
public class FindAllProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";

        try {
            // DAOクラスをインスタンス化


            // 全件検索


            // リクエストへ登録



        } catch (Exception e) {
            e.printStackTrace();
        }
        // フォワード設定


        // フォワード

    }
}