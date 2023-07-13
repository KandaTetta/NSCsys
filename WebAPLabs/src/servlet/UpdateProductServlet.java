package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 商品更新メニューをコントロールするサーブレット
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                                        throws ServletException, IOException {
	    String nextPage = "ProductError.jsp";

	    // リクエストパラメータを取得



	    // Productオブジェクト生成


	    // DAOクラスをインスタンス化


	    // 商品情報を更新


	    // リクエストへ更新に使った商品情報を登録


        // フォワード設定


        // フォワード

	}
}