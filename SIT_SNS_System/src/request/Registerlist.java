package request;

import java.io.IOException;
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
 * Servlet implementation class Registerlist
 */
@WebServlet("/Registerlist")
public class Registerlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//画面遷移の準備
		String forwardPath = null;

		// フォワード
		forwardPath = "/home.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//学科を取得
		String sub = request.getParameter("subject");
		request.setAttribute("subject", sub);

		//データベースの準備
	    Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		//変数の準備
		ArrayList<String> studentid = new ArrayList<String>();                                          //学籍番号
		ArrayList<String> studentname = new ArrayList<String>();                                       //学生の名前
		ArrayList<String> textid = new ArrayList<String>();                              //教科書ID
		ArrayList<String> textname = new ArrayList<String>();                                          //教科書名
		ArrayList<String> author = new ArrayList<String>();                                            //著者
		ArrayList<String> publish = new ArrayList<String>();                                           //出版社
		ArrayList<String> campus = new ArrayList<String>();                                            //キャンパス

		//データベースから情報を取得
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
			conn = DriverManager.getConnection(url,"master","Pracb2021*");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM REGISTER_LIST WHERE SUBJECT='" + sub + "'";
			rs = stmt.executeQuery(sql);

			int i=0;

			while (rs.next()) {

			studentid.add(rs.getString("STUDENTID"));
			studentname.add(rs.getString("STUDENTNAME"));
			textid.add(rs.getString("TEXTID"));
			textname.add(rs.getString("TEXTNAME"));
			author.add(rs.getString("AUTHOR"));
			publish.add(rs.getString("PUBLISHER"));
			campus.add(rs.getString("CAMPUS"));

			i++;

			}


			request.setAttribute("count", i);
			request.setAttribute("s_id_list", studentid);
			request.setAttribute("s_name_list", studentname);
			request.setAttribute("t_id_list", textid);
			request.setAttribute("t_name_list", textname);
			request.setAttribute("author_list", author);
			request.setAttribute("pub_list", publish);
			request.setAttribute("cam_list", campus);

		    conn.close();
		    stmt.close();
	    } catch(Exception e){
		      e.printStackTrace();
	    }

		// フォワード
		getServletConfig().getServletContext().getRequestDispatcher("/textbooklist.jsp").forward(request, response);
	}

}
