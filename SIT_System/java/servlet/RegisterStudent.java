
/**************************************************************************************************
 ***  File Name      : RegisterStudent.java
 ***  Version        : V1.4
 ***  Designer       : 寺岡
 ***  Date           : 2021.07.09
 ***  Purpose        : ログインした学籍番号に基づく時間割を表示させる。
 ***                   設定画面、教科書リスト画面、チャット画面へ遷移させる。
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 永井海音,2021.06.17
 *** V1.1 : 永井海音,2021.06.20
 *** V1.2 : 永井海音,2021.06.25
 *** V1.3 : 永井海音,2021.07.02
 *** V1.4 : 永井海音,2021.07.09
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

import beans.StudentModel;
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
		      logic.registerStudentAccount(registerStudent);
		 
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
		    StudentModel registerStudent = new StudentModel(id,pass,name);
		    RegisterStudentDAO Check = new RegisterStudentDAO();
		    
		    // 新規アカウント登録エラー確認
			
			// パスワードとパスワード（確認用）が一致しない場合	
		    if(pass.equals(pass_check) == false) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentPassNotmatch.jsp";
		    	
				    
			// 学科に対応しない学籍番号が入力された場合
		    }else if(id.matches("A[A-H][0-9]{5}") == false && id.matches("AL[0-9]{5}") == false && 
		              id.matches("BN[0-9]{5}") == false && id.matches("[B][P-R][0-9]{5}") == false  && id.matches("[B][V][0-9]{5}") == false &&
		              id.matches("[C][Y][0-9]{5}") == false  && id.matches("[D][Z][0-9]{5}") == false ) {
		    	// フォワード先を設定
		    	forwardPath = "jsp/registerStudent/registerStudentIDNotExist.jsp";
		    	
				    
			// 登録する学籍番号が既に登録されている場合
		    }else if(Check.registerCheck(registerStudent) != true) {
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
