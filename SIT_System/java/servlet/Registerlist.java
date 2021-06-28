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

/**
 * Servlet implementation class Registerlist
 */
@WebServlet("/Registerlist")
public class Registerlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//画面遷移の準備
		String forwardPath = null;

		String sub = "情報工学科";

		HttpSession session = request.getSession();
		//sub= ((ServletRequest) session).getParameter("subject");
		RegisterListLogic rll = new RegisterListLogic();
		List<RegisterListModel> registerList = rll.makeRegisterList(sub);//test 情報工学科
//		for(int i =0;i<registerList.size();i++) {
//			System.out.println(registerList.get(i).getTextName());
//		}
		session.setAttribute("register", registerList);
		//("register", registerList);
		// フォワード
		forwardPath = "jsp/textbooklist/textbooklist.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//学科を取得
		//String sub = request.getParameter("subject");
		//request.setAttribute("subject", sub);
		//変数の準備

		// フォワード

	}

}
