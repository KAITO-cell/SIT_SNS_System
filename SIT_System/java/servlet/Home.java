package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		ScheduleLogic scheduleLogic = new ScheduleLogic();
		System.out.println("てらおか") ;

		try {

			List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule();
			request.setAttribute("scheduleList", scheduleList);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		String[] period = new String[48];
		period[1]= "ENGLISH";
		period[2]= "MATH";
		period[3]= "JAVA";
//		int count=0;
//		while(count<47) {
//			period[count] = "C言語";
//		}
//
	      HttpSession session = request.getSession();
		  session.setAttribute("period", period);
		//request.setAttribute("period", period);

		RequestDispatcher dis = request.getRequestDispatcher("/jsp/home/Home.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String act = request.getParameter("act");
		
		
		
		if (act == null) {
		    
			
			ScheduleLogic scheduleLogic = new ScheduleLogic();
			System.out.println("1") ;
			
			try {

				List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule();
				request.setAttribute("scheduleList", scheduleList);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


			String[] period = new String[48];
			period[1]= "ENGLISH";
			period[2]= "MATH";
			period[3]= "JAVA";
//			int count=0;
//			while(count<47) {
//				period[count] = "C言語";
//			}
	//
		    HttpSession session = request.getSession();
			session.setAttribute("period", period);
			
			  // フォワード先を設定
			RequestDispatcher dis = request.getRequestDispatcher("/jsp/home/Home.jsp");
			dis.forward(request, response);
		      
		}
		if(act.equals("done")) {
			RequestDispatcher dis = request.getRequestDispatcher("/jsp/home/Setting.jsp");
			dis.forward(request, response);
		}

		HttpSession session = request.getSession();
		session = request.getSession();
		String[] period = (String[]) session.getAttribute("period");
		List<String> timetable = new ArrayList<String>();

		for(int i=0;i<period.length;i++) {
			String str = request.getParameter("period["+i+"]");
			System.out.println("Home:doPost"+period[i]+" "+str);
			timetable.add(period[i]);
		}


		request.setAttribute("timetable", timetable);

//
//		if(act.equals("done")) {
//			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Setting.jsp");
//			dis.forward(request, response);
//		}
//


	}

}
