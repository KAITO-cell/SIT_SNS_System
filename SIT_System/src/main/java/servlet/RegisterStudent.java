package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.StudentModel;
import dao.RegisterStudentCheckDAO;
import dao.RegisterStudentDAO; 

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
		    
		    // リクエストパラメータの取得
		    request.setCharacterEncoding("UTF-8");
		    String id = request.getParameter("test1");
		    String pass = request.getParameter("test2");
		    String name = request.getParameter("test3");
		    
		    // 登録するユーザーの情報を設定
		    StudentModel registerStudent = new StudentModel(id,pass,name);

		    //「登録の開始」をリクエストされたときの処理
		    if (action == null) {
		      // フォワード先を設定
		      forwardPath = "jsp/registerStudent/registerStudent.jsp";
		      
		    }

		    // 登録確認画面から「登録実行」をリクエストされたときの処理
		    else if (action.equals("done")) {
		 
		      // セッションスコープに保存された登録ユーザ
		      HttpSession session = request.getSession();
			  session.setAttribute("registerUser", registerStudent);

		      // 登録処理の呼び出し
		      RegisterStudentDAO logic = new RegisterStudentDAO();
		      logic.execute(registerStudent);
		 
		      // 不要となったセッションスコープ内のインスタンスを削除
		      session.removeAttribute("registerStudent");
		      session.removeAttribute("registerUser");

		      // 登録後のフォワード先を設定
		      forwardPath = "jsp/registerStudent/registerStudentResult.jsp";
		    }
		    

		    // 設定されたフォワード先にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		  }
	
	

		  protected void doPost(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {
			
			// フォワード先
			String forwardPath = null;

		    // リクエストパラメータの取得
		    request.setCharacterEncoding("UTF-8");
		    String id = request.getParameter("id");
		    String pass = request.getParameter("pass");
		    String pass_check = request.getParameter("pass_check");
		    String name = request.getParameter("name");

		    // 登録するユーザーの情報を設定
		    StudentModel registerStudent = new StudentModel(id,pass,pass_check,name);
		    RegisterStudentCheckDAO Check = new RegisterStudentCheckDAO();
		    
		    // 新規アカウント登録エラー確認
		    
		    // 学籍番号、パスワード、パスワード（確認用）のいずれかが未入力の場合
		    if(id.length() == 0 || pass.length() == 0 || pass_check.length() == 0) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentNull.jsp";
		    	
		    	
			// 学籍番号が７文字で入力されていない場合
		    }else if(id.length() != 7 ) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentIDE7.jsp";
		    	
			
			// パスワードとパスワード（確認用）が一致しない場合	    
		    }else if(pass.equals(pass_check) == false) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentPassNotmatch.jsp";
		    	
			
		    // パスワードが半角英数字６～８文字で入力されていない場合
		    }else if(pass.matches("[a-zA-Z0-9]{6,8}") == false) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentPassE6-8.jsp";
		    	
				    
			// 学科に対応しない学籍番号が入力された場合
		    }else if(id.matches("A[A-H][0-9]{5}") == false && id.matches("AL[0-9]{5}") == false && 
		              id.matches("BN[0-9]{5}") == false && id.matches("[B][P-R][0-9]{5}") == false  && id.matches("[B][V][0-9]{5}") == false &&
		              id.matches("[C][Y][0-9]{5}") == false  && id.matches("[D][Z][0-9]{5}") == false ){
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentIDNotExist.jsp";
		    	
			
		    // 名前が２０字以内で入力されていない場合
		    }else if(name.length() > 20 ) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentNameOver.jsp";
		    	
				    
			// 登録する学籍番号が既に登録されている場合
		    }else if(Check.execute(registerStudent) != true) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentBooking.jsp";
		    	
				
		    // エラーがない場合（登録する条件を満たしている場合）
		    }else {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentCheck.jsp";
		    	
		    	// セッションスコープに登録ユーザーを保存
			    HttpSession session = request.getSession();
			    session.setAttribute("registerUser", registerStudent);
		    }
		    

		    // 設定されたフォワード先にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		  }
}
