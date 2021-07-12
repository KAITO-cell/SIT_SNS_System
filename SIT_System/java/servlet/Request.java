/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V1.3
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.02
 ***  Purpose        : データベースから教科書リスト画面で選択された教科書の情報を取得し、
 ***                   セッションに登録する。
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.19
 *** V1.1 : 奈良操樹,2021.06.20
 *** V1.2 : 奈良操樹,2021.06.25
 *** V1.3 : 奈良操樹,2021.07.02
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Logic.RegisterListLogic;
import beans.RegisterListModel;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//変数の準備
		String forwardPath = null;
		HttpSession session = request.getSession();

		//変数の準備
		String studentid = "0";                                          //学籍番号
		String textid =request.getParameter( "textid");                  //教科書ID

		//教科書画面リストのプルダウンでのエラーの場合
		if(textid.equals("-1")){

			//エラー画面に遷移
			forwardPath = "jsp/textbooklist/error.jsp";
	        RequestDispatcher dispatcher =
			    request.getRequestDispatcher(forwardPath);
			    dispatcher.forward(request, response);
            return ;
         }

		//データベースから情報を取得
        RegisterListLogic rll = new RegisterListLogic();
        RegisterListModel textidrecode = rll.makeTextidcode(textid);

        //学籍番号を取得
        studentid=textidrecode.getStudentID();

		//データベースに選択したものがなかった場合、エラー画面に遷移
		if(studentid=="0") {
			// フォワード
			forwardPath = "jsp/textbooklist/error.jsp";
		    RequestDispatcher dispatcher =
					    request.getRequestDispatcher(forwardPath);
					    dispatcher.forward(request, response);
		    return ;
		}

		//セッションスコープに各データを保存
		session.setAttribute("s_id", textidrecode.getStudentID());
		session.setAttribute("s_name", textidrecode.getStudentName());
		session.setAttribute("t_id", textidrecode.getTextID());
		session.setAttribute("t_name", textidrecode.getTextName());
		session.setAttribute("author", textidrecode.getAuthor());
		session.setAttribute("pub", textidrecode.getPublish());
		session.setAttribute("cam", textidrecode.getCampus());
		session.setAttribute("subject", textidrecode.getSubject());

		//次の処理をセット
		String action = "getChat";
		request.setAttribute("act", action);

		// フォワード
		forwardPath = "/RequestChat";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);
	  }
}

