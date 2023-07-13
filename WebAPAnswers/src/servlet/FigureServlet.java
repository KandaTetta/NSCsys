package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Rectangle;

@WebServlet("/FigureServlet")
public class FigureServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // リクエストパラメータを取得
            double height = Double.parseDouble(request.getParameter("height"));
            double width = Double.parseDouble(request.getParameter("width"));

            // Rectangleオブジェクトを生成
            Rectangle rect = new Rectangle(height, width);

            // リクエストへ格納
            request.setAttribute("rectangle", rect);

        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // 次画面へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("ResultArea.jsp");
        rd.forward(request, response);
    }
}