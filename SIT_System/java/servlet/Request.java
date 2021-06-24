package request;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//画面遷移の準備
		String forwardPath = null;

		// フォワード
		forwardPath = "/WEB-INF/textbooklist.jsp";
	    RequestDispatcher dispatcher =
				    request.getRequestDispatcher(forwardPath);
				    dispatcher.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//データベースの準備
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		//変数の準備
		String studentid="'"+request.getParameter( "studentid")+ "'"; //学籍番号
		String studentname="";                                       //学生の名前
		String textid = "";                                          //教科書ID
		String textname="";                                          //教科書名
		String author="";                                            //著者
		String publish="";                                           //出版社
		String campus="";                                            //キャンパス

		//データベースから情報を取得
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
			conn = DriverManager.getConnection(url,"master","Pracb2021*");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM REGISTER_LIST WHERE STUDENTID=" + studentid;
			rs = stmt.executeQuery(sql);

			rs.next();

			studentname=rs.getString("STUDENTNAME");
			textid=rs.getString("TEXTID");
			textname=rs.getString("TEXTNAME");
			author=rs.getString("AUTHOR");
			publish=rs.getString("PUBLISHER");
			campus=rs.getString("CAMPUS");

		    conn.close();
		    stmt.close();
	    } catch(Exception e){
		      e.printStackTrace();
	    }

		//データベースに選択したものがなかった場合、エラー画面に遷移
		if(textid=="") {
			// フォワード
		    getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

		//リクエストパラメータのセット
		request.setAttribute("s_name", studentname);
		request.setAttribute("t_id", textid);
		request.setAttribute("t_name", textname);
		request.setAttribute("author", author);
		request.setAttribute("pub", publish);
		request.setAttribute("cam", campus);

		// フォワード
	    getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/requestscreen.jsp").forward(request, response);
	  }
}

