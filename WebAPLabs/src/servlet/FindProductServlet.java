package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;

// 商品検索メニューをコントロールするサーブレット
@WebServlet("/FindProductServlet")
public class FindProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        String nextPage = "ProductError.jsp";
        Product product = null; // 商品オブジェクト
        int productNo = 0; // 商品番号

        // リクエストパラメータを取得


        // リクエストパラメータが取得できていたらデータベースへ検索を行う

            try {


                // DAOクラスをインスタンス化


                // 商品を検索


                // 商品情報をリクエストへ登録


                // フォワード先を商品表示画面へ設定

            } catch (Exception e) {
                e.printStackTrace();
            }

            // フォワード設定


            // フォワード


    }
}