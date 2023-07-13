package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BankingDispatcherServlet")
public class BankingDispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 次画面のURLを格納する変数の宣言
        String nextPage = null;

        // リクエストパラメータの取得
        String menu = request.getParameter("menu");

        // フォワード先の設定
        if (menu == null || menu.isEmpty()) {
            nextPage = "banking.html";
        } else {
            switch (menu) {
            case "com1":
                nextPage = "Com1Menu.jsp";
                break;
            case "com2":
                nextPage = "Com2Menu.jsp";
                break;
            case "com3":
                nextPage = "Com3Menu.jsp";
            }
        }

        // RequestDispatcherの獲得
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);

        // 次画面へフォワード
        rd.forward(request, response);
    }
}