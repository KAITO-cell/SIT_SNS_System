package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		}/* finally {
			try{
				rs.close();
			} catch (SQLException sqlEx) {

			}try{
				stmt.close();
			} catch (SQLException sqlEx) {

			}try{
				conn.close();
			} catch (SQLException sqlEx) {

			}
			if (rs!=null) {
				try {
					rs.close();
				} catch(SQLException sqlEx) {
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch(SQLException sqlEx) {
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch(SQLException sqlEx) {
				}
			}
		}*/

		//response.setContentType("text/html; charset=UTF-8");
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
}