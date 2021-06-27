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
 * Servlet implementation class insertSampleServlet
 */
@WebServlet("/insertSampleServlet")
public class insertSampleServlet extends HttpServlet {
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

				String sql = "INSERT INTO REGISTER_LIST VALUES('8','AL19077','小倉','工学部','情報工学科','統計の教科書','株式会社SCC','松尾　とおる','大宮');";
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
		out.println("<h1>" + ret + "件追加しました。</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
