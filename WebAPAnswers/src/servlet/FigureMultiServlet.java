package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Figure;
import beans.Rectangle;
import beans.Triangle;

@WebServlet("/FigureMultiServlet")
public class FigureMultiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // リクエストパラメータを取得
            String type = request.getParameter("type");
            double height = Double.parseDouble(request.getParameter("height"));
            double width = Double.parseDouble(request.getParameter("width"));

            // 図形オブジェクトを生成
            Figure figure = null;

            switch(type){
            case "rectangle":
                figure = new Rectangle(height,width);
                break;
            case "triangle":
                figure = new Triangle(height,width);
                break;
            }

            // リクエストへ格納
            request.setAttribute("figure", figure);

        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // 次画面へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("ResultMultiArea.jsp");
        rd.forward(request, response);
    }
}
