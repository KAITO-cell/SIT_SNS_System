package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterStudentLogic;
import model.Student; 

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {

		    // フォワード先
		    String forwardPath = null;


		    // サーブレットクラスの動作を決定する「action」の値を
		    // リクエストパラメータから取得
		    String action = request.getParameter("act");

		    // 「登録の開始」をリクエストされたときの処理
		    if (action == null) {
		      // フォワード先を設定
		      forwardPath = "/WEB-INF/jsp/registerStudent.jsp";
		      
		    }

		    // 登録確認画面から「登録実行」をリクエストされたときの処理
		    else if (action.equals("done")) {
		      // セッションスコープに保存された登録ユーザ
		      HttpSession session = request.getSession();
		      Student registerUser = (Student) session.getAttribute("registerUser");

		      // 登録処理の呼び出し
		      RegisterStudentLogic logic = new RegisterStudentLogic();
		      logic.execute(registerUser);

		      // 不要となったセッションスコープ内のインスタンスを削除
		      session.removeAttribute("registerUser");

		      // 登録後のフォワード先を設定
		      forwardPath = "/WEB-INF/jsp/registerStudentResult.jsp";
		    }
		    

		    // 設定されたフォワード先にフォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		  }
	
	

		  protected void doPost(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {
			 

		    // リクエストパラメータの取得
		    request.setCharacterEncoding("UTF-8");
		    String id = request.getParameter("id");
		    String pass = request.getParameter("pass");
		    String pass_check = request.getParameter("pass_check");
		    String name = request.getParameter("name");

		    // 登録するユーザーの情報を設定
		    Student registerUser = new Student(id,pass,pass_check,name);
		    
		    //if(id == null || id.length() == 0)
		    if(id.length() == 0 || pass.length() == 0 || pass_check.length() == 0){
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentNull.jsp");
				    dispatcher.forward(request, response);
		    }else if(id.length() != 7 ) {
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentIDE7.jsp");
				    dispatcher.forward(request, response);
		    }else if(pass.equals(pass_check) == false) {
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentPassNotmatch.jsp");
				    dispatcher.forward(request, response);
		    }else if(pass.matches("[a-zA-Z0-9]{6,8}") == false) {
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentPassE6-8.jsp");
				    dispatcher.forward(request, response);
		    }else if(id.matches("A[A-H][0-9]{5}") == false && id.matches("AL[0-9]{5}") == false && 
		              id.matches("BN[0-9]{5}") == false && id.matches("[B][P-R][0-9]{5}") == false  && id.matches("[B][V][0-9]{5}") == false &&
		              id.matches("[C][Y][0-9]{5}") == false  && id.matches("[D][Z][0-9]{5}") == false ) {
		    //}else if(id.matches("AL19027") == false) {
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentIDNotExist.jsp");
				    dispatcher.forward(request, response);
		    }else if(name.length() > 20 ) {
		    	RequestDispatcher dispatcher =
				        request.getRequestDispatcher
				            ("/WEB-INF/jsp/registerStudentNameOver.jsp");
				    dispatcher.forward(request, response);
		    }
		    //else if(id == A[A-H][0-9]{5} || AL[0-9]{5})
		    //else if(id == BN[0-9]{5} || B[P-R][0-9]{5} || BV[0-9]{5})
		    //else if(id == CY[0-9]{5} || DZ[0-9]{5})
		    
		    

		    

		    // セッションスコープに登録ユーザーを保存
		    HttpSession session = request.getSession();
		    session.setAttribute("registerUser", registerUser);

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/registerStudentCheck.jsp");
		    dispatcher.forward(request, response);
		  }
}
