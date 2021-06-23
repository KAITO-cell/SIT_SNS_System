package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Student;
import dao.Logic;

@WebServlet("/SIT_SNS_system_login")

public class SIT_SNS_system_login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/UICertify.jsp");
		dispatcher.forward(req,  res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		
		//リクエストパラメータ所得
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		
		//学生情報の生成
		Student student = new Student(id,pass);
		
		//ログイン処理
		Logic loginLogic = new Logic();
		boolean isLogin = loginLogic.execute(student);
		
		//ログイン成功時
		if(isLogin==true) {
			//ユーザー情報をセッションスコープに保存
			HttpSession session = req.getSession();
			session.setAttribute("loginStudent", id);
			
			//ログイン結果画面にフォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login_success.jsp");
			dispatcher.forward(req,  res);
			
		}else {
			//ログイン結果画面にフォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login_result.jsp");
			dispatcher.forward(req,  res);
		}
	}
}

