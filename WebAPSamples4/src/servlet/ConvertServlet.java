package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PersonalData;

// MVCのCにあたるサーブレット
@WebServlet("/ConvertServlet")
public class ConvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "Error.jsp"; // 遷移先JSP

        // リクエストパラメータの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータを取得する
        String name = request.getParameter("name");
        String strYear = request.getParameter("year");

        // 入力内容をチェック
        if (name != null && strYear != null
                                    && !name.isEmpty() && !strYear.isEmpty()) {
            try {
                // 西暦年を数値に変換
                int adYear = Integer.parseInt(strYear);

                // MVCのModelクラスをインスタンス化
                PersonalData data = new PersonalData(name, adYear);

                // 干支の情報をJSPで表示するためにリクエストに保存して共有
                request.setAttribute("pData", data);

                // 遷移先：結果を表示する画面
                nextPage = "ResultZodiac.jsp";

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        // JSPへ画面遷移指定
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);

        // フォワード
        rd.forward(request, response);
    }
}