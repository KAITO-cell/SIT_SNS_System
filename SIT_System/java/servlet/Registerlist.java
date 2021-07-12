
/**************************************************************************************************
 ***  File Name      : RegisterList.java
 ***  Version        : V1.3
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.03
 ***  Purpose        : ホーム画面で選択された学科、その学科で登録されている教科書の情報、
 ***                   自分が登録した教科書の情報をセッションに登録し、教科書リスト画面に遷移する。
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.26
 *** V1.1 : 奈良操樹,2021.06.28
 *** V1.2 : 奈良操樹,2021.07.02
 *** V1.3 : 奈良操樹,2021.07.03
 */
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Logic.RegisterListLogic;
import beans.RegisterListModel;
import dao.RegisterListDAO;

/**
 * Servlet implementation class Registerlist
 */
@WebServlet("/RegisterList")
public class RegisterList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//画面遷移の準備
		String forwardPath = null;

		//アクション別に処理
		String action=request.getParameter("action");

		//セッションIDを生成
		HttpSession session = request.getSession();

		//学籍番号の取得
		String studentID = (String)session.getAttribute("loginStudent");

		if((action.equals("home"))){

			//学科をセッションに登録
			String sub =request.getParameter("subject");
			session.setAttribute("subject", sub);

		}


		//データベースから指定された学科で登録されている教科書のデータを取得
		RegisterListLogic rll = new RegisterListLogic();
		List<RegisterListModel> registerList = rll.makeRegisterList((String) session.getAttribute("subject"));
		session.setAttribute("register", registerList);

		//データベースから自身の学籍番号で登録されている教科書のデータを取得
		RegisterListDAO logic = new RegisterListDAO();
		List<RegisterListModel> MyList = logic.getMyTextList(studentID);

		// セッションスコープに自身が登録している教科書を保存
		session.setAttribute("mytextlist", MyList);


		// フォワード
		forwardPath = "jsp/textbooklist/textbooklist.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);
	}
}
