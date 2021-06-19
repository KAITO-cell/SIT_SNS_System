package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSampleServlet
 */
@WebServlet("/DeleteSampleServlet")
public class DeleteSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ret =0;
		Connection conn = null;
		Statement stmt = null;

		try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
				conn = DriverManager.getConnection(url,"master","Pracb2021*");
				stmt = conn.createStatement();

				String sql = "DELETE FROM REGISTERLIST WHERE TEXTID='AL19070_2'";
				ret = stmt.executeUpdate(sql);


		}catch(Exception e){
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>データベース接続のサンプルサーブレットInsert</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + ret + "件削除しました。</h1>");
		out.println("</body>");
		out.println("</html>");
	}


}
