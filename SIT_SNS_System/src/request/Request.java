package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardPath = null;

		      // フォワード先を設定
		forwardPath = "/WEB-INF/textbooklist.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://160.16.141.77:51601/STUDENT";
				conn = DriverManager.getConnection(url,"master","Pracb2021*");
				stmt = conn.createStatement();

				String sql = "SELECT * FROM test";
				rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String s = "<td>" + rs.getString("NAME") + "</td>"
						+ "<td>" + rs.getInt("AGE") + "</td>"
						+ "<td>" + rs.getString("MESSAGE") + "</td>";
				list.add(s);

			}
			conn.close();
			stmt.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>データベース接続のサンプルサーブレットSelect</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<th>学籍番号</th>");
		out.println("<th>学生氏名</th>");
		out.println("<th>学年</th>");
		out.println("</tr>");
		for (String str : list) {
			out.println("<tr>" + str + "</tr>");
			System.out.println(str);
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    float num1 = 0;
	    float num2 = 0;
	    float resultNum;

	    try {
	      num1 = Float.parseFloat(request.getParameter("num1"));
	      num2 = Float.parseFloat(request.getParameter("num2"));
	      resultNum = num1 + num2;
	    } catch (NumberFormatException e) {
	      resultNum = 0;
	    }

	    request.setAttribute("num1", num1);
	    request.setAttribute("num2", num2);
	    request.setAttribute("resultNum", resultNum);

	    getServletConfig().getServletContext().
	      getRequestDispatcher("/WEB-INF/requestscreen.jsp").forward(request, response);
	  }
}

