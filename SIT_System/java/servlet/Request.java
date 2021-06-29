package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logic.RegisterListLogic;
import beans.RegisterListModel;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//画面遷移の準備
		/*String forwardPath = null;

		// フォワード
		forwardPath = "/textbooklist.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);
*/
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardPath = null;

		//変数の準備
		String studentid = "0";                                          //学籍番号
		String textid =request.getParameter( "textid"); //教科書ID



		//データベースから情報を取得
        RegisterListLogic rll = new RegisterListLogic();
        RegisterListModel textidrecode = rll.makeTextidcode(textid);


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

		//リクエストパラメータのセット
		request.setAttribute("s_id", textidrecode.getStudentID());
		request.setAttribute("s_name", textidrecode.getStudentName());
		request.setAttribute("t_id", textidrecode.getTextID());
		request.setAttribute("t_name", textidrecode.getTextName());
		request.setAttribute("author", textidrecode.getAuthor());
		request.setAttribute("pub", textidrecode.getPublish());
		request.setAttribute("cam", textidrecode.getCampus());
		request.setAttribute("subject", textidrecode.getSubject());

		// フォワード
		forwardPath = "jsp/textbooklist/requestscreen.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);
				    return ;
	  }
}

