/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V2.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.11
 ***  Purpose        : 教科書リスト画面で選択された教科書の情報をセッションに登録する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.28
 *** V1.1 : 奈良操樹,2021.07.02
 */
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

		//パラメータを取得
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

		//パラメータを保存
		request.setAttribute("action", action);

	}
}
