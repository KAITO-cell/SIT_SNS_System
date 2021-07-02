package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterListDAO;

/**
 * Servlet implementation class RequestComplete
 */
@WebServlet("/RequestComplete")
public class RequestComplete extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//画面遷移の準備
		String forwardPath = null;

		String action = request.getParameter("action");

		//「完了」ボタンが押された場合
		if(action.equals("complete")) {

			//リクエストパラメータを取得
			String textid = request.getParameter("textid");

			//データベースから登録されている教科書を削除
			RegisterListDAO dao = new RegisterListDAO();
			dao.deleteText(textid);

			//フォワード
		    forwardPath = "/RegisterList";
	        RequestDispatcher dispatcher =request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		}

		request.setAttribute("action", action);

	}

}
