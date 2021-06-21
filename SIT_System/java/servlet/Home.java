package sit.sns.system;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

		try {

			List<ScheduleModel> scheduleList = scheduleLogic.makeSchedule();
			request.setAttribute("scheduleList", scheduleList);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Home.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);



		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Setting.jsp");
		dis.forward(request, response);



	}

}
