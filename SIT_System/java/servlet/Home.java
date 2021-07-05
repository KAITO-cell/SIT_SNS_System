package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Logic.ScheduleLogic;
import beans.ScheduleModel;
import beans.StudentModel;
import dao.RegisterStudentDAO;
import dao.ScheduleDAO;
/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String act = request.getParameter("act");
		
		if(act.equals("chat")) {
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/LoginChatRoom.jsp");
			dis.forward(request, response);
			
		}else if(act.equals("back")){
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Home.jsp");
			dis.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		HttpSession session = request.getSession();
		String stdid = (String)session.getAttribute("loginStudent");
		ScheduleDAO initDao =new ScheduleDAO();

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String pass_check = request.getParameter("pass_check");
		String name = request.getParameter("name");

		if(act == null) {

			if(!initDao.exsistTimeTable(stdid)) {
				//時間割初期化
				initDao.initTimeTable(stdid);
			}
			
			ScheduleLogic scheduleLogic = new ScheduleLogic();
			
			try {
				List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule(stdid);
				session.setAttribute("scheduleList", scheduleList);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Home.jsp");
			dis.forward(request, response);

		// ログアウト処理
		}else if(act.equals("logout")) {

			// 不要となったセッションスコープ内のインスタンスを削除
		    session.removeAttribute("loginStudent");
		    session.removeAttribute("scheduleList");
		    session.removeAttribute("subject");

			// フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("jsp/login/UICertify.jsp");
			dis.forward(request, response);

		// 時間割変更処理画面に遷移
		}else if(act.equals("done")) {

			// フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Setting.jsp");
			dis.forward(request, response);

		// 名前変更処理画面に遷移
		}else if(act.equals("name")) {

			// フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingName.jsp");
			dis.forward(request, response);

		// 名前変更処理
		}else if(act.equals("nameChange")) {

			// 名前が２０字以内で入力されていない場合
		    if(name.length() > 20 ) {

		    	// フォワード先を設定
		    	RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingNameError.jsp");
				dis.forward(request, response);

			// エラーがない場合（名前が２０字以内で入力されている場合）
		    }else {

		    	// 変更する名前の情報を設定
		    	StudentModel registerStudent = new StudentModel(stdid,pass,name);
		    	RegisterStudentDAO nameChange = new RegisterStudentDAO();

		    	// データベースで名前変更を行う処理
		    	nameChange.nameUpdate(registerStudent) ;

		    	// フォワード先を設定
		    	RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingNameResult.jsp");
		    	dis.forward(request, response);
		    }

		 // パスワード変更処理画面に移動
		}else if(act.equals("pass")) {

			// フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingPass.jsp");
			dis.forward(request, response);

		// パスワード変更処理
		}else if(act.equals("passChange")) {

			// パスワード、パスワード（確認用）のいずれかが未入力の場合
			// パスワードが半角英数字６～８文字で入力されていない場合
		    if(pass.length() == 0 || pass_check.length() == 0 || pass.matches("[a-zA-Z0-9]{6,8}") == false) {

		    	// フォワード先を設定
		    	RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingPassError.jsp");
				dis.forward(request, response);

			// パスワードとパスワード（確認用）が一致しない場合
		    }else if(pass.equals(pass_check) == false) {

		    	// フォワード先を設定
		    	RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingPassNotmatch.jsp");
				dis.forward(request, response);

			// エラーがない場合
		    }else {

		    	// 変更するユーザーの情報を設定
		    	StudentModel registerStudent = new StudentModel(stdid,pass,name);
		    	RegisterStudentDAO passChange = new RegisterStudentDAO();

		    	// データベースでパスワード変更を行う処理
		    	passChange.passUpdate(registerStudent) ;

		    	// フォワード先を設定
		    	RequestDispatcher dis = request.getRequestDispatcher("jsp/home/SettingPassResult.jsp");
		    	dis.forward(request, response);
		    }

		// ホーム画面に戻る処理
		}else if(act.equals("back")) {

			// フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Home.jsp");
			dis.forward(request, response);

		// 時間割変更処理
		}else if(act.equals("home")) {
			request.setCharacterEncoding("UTF-8");

			String tableName="";
			String week="";
			String fir = request.getParameter("fir");
			String sec = request.getParameter("sec");
			String thr = request.getParameter("thr");
			String fou = request.getParameter("fou");
			String fif = request.getParameter("fif");
			String six = request.getParameter("six");
			String sev = request.getParameter("sev");

			//データベースに登録してその内容表示
			String sta = request.getParameter("state");

			switch(sta) {
				case "mon": 
					tableName = "MONDAY";
					week = "MON";
					break;
					
				case "tue": 
					tableName = "TUESDAY";
					week = "TUE";
					break;
					
				case "wed": 
					tableName = "WEDNESDAY";
					week = "WED";
					break;
					
				case "thu": 
					tableName = "THURSDAY";
					week = "THU";
					break;
					
				case "fri": 
					tableName = "FRIDAY";
					week = "FRI";
					break;
					
				case "sat": 
					tableName = "SATURDAY";
					week = "SAT";
					break;
					
				default: 
					tableName = "MONDAY";
			}

			if( fir == null) {
				fir = "0";
			}
			
			if( sec == null) {
				sec = "0";
			}
			
			if( thr == null) {
				thr = "0";
			}
			
			if( fou == null) {
				fou = "0";
			}
			
			if( fif == null) {
				fif = "0";
			}
			
			if( six == null) {
				six = "0";
			}
			
			if( sev == null) {
				sev = "0";
			}
			
			ScheduleModel table = new ScheduleModel(fir, sec, thr, fou, fif, six, sev);
			ScheduleDAO dao = new ScheduleDAO();
			dao.insertTimeTable(table, tableName, week, stdid);
			
			ScheduleLogic scheduleLogic = new ScheduleLogic();

			try {
				List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule(stdid);
				session.setAttribute("scheduleList", scheduleList);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Home.jsp");
			dis.forward(request, response);

		}
	}
}
