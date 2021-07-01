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
import dao.ScheduleDAO;
/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ScheduleDAO student = new ScheduleDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		// 学籍番号を取得して時間割表示
//		ScheduleLogic scheduleLogic = new ScheduleLogic();
//		try {
//
//			List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule();
//		    HttpSession session = request.getSession();
//			session.setAttribute("scheduleList", scheduleList);
//
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Home.jsp");
//		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);

		String act = request.getParameter("act");
		HttpSession session = request.getSession();
		String stdid = (String)session.getAttribute("loginStudent");
		System.out.println("stdid="+stdid);
		ScheduleDAO initDao =new ScheduleDAO();

		if(act==null) {

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

		}else if(act.equals("done")) {
			
			RequestDispatcher dis = request.getRequestDispatcher("jsp/home/Setting.jsp");
			dis.forward(request, response);
			
		}else if(act.equals("home")) {
			System.out.println("fir"+request.getParameter("fir"));
			System.out.println("sec"+request.getParameter("sec"));
			System.out.println("thi"+request.getParameter("thr"));
			System.out.println("for"+request.getParameter("fou"));
			System.out.println("fif"+request.getParameter("fif"));
			System.out.println("six"+request.getParameter("six"));


			String tableName="";
			String week="";
			String fir;
			String sec;
			String thr;
			String fou;
			String fif;
			String six;
			String sev;

			//データベースに登録してその内容表示
			String sta = request.getParameter("state");
			
			if(request.getParameter("fir")==null) {
				fir="0";
				System.out.println(fir);
			}else {
				fir = request.getParameter("fir");
			}
			if(request.getParameter("sec")==null) {
				sec="0";
				System.out.println(sec);
			}else {
				sec = request.getParameter("sec");
			}
			if(request.getParameter("thr")==null) {
				thr="0";
				System.out.println(thr);
			}else {
				thr = request.getParameter("thr");
			}
			if(request.getParameter("fou")==null) {
				fou="0";
				System.out.println("for"+fou);
			}else {
				fou = request.getParameter("fou");
			}
			if(request.getParameter("fif")==null) {
				fif="0";
				System.out.println(fif);
			}else {
				fif = request.getParameter("fif");
			}
			if(request.getParameter("six")==null) {
				six="0";
				System.out.println("six "+six);
			}else {
				six = request.getParameter("six");
			}
			if(request.getParameter("sev").equals(null)) {
				sev="0";
				System.out.println("sev"+sev);
			}else {
				sev = request.getParameter("sev");
			}
			switch(sta) {
				case "mon": tableName="MONDAY";week="MON";break;
				case "tue": tableName="TUESDAY";week="TUE";break;
				case "wed": tableName="WEDNESDAY";week="WED";break;
				case "thu": tableName="THURSDAY";week="THU";break;
				case "fri": tableName="FRIDAY";week="FRI";break;
				case "sat": tableName="SATURDAY";week="SAT";break;
				default: tableName = "MONDAY";
			}


			ScheduleModel table = new ScheduleModel(fir,sec,thr,fou,fif,six,sev);
			ScheduleDAO dao = new ScheduleDAO();


			dao.insertTimeTable(table, tableName,week,stdid);



			System.out.println("TAG:Home2 stdid="+stdid);


			System.out.println(sta+" "+fir+" "+sec+" "+thr+" "+fou+" "+fif+" "+six+" "+sev);

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
