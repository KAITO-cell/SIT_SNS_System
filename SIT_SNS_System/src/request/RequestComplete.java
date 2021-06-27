package request;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestComplete
 */
@WebServlet("/RequestComplete")
public class RequestComplete extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//画面遷移の準備
		String forwardPath = null;

		String action = request.getParameter("action");

		//「戻る」ボタンが押された場合
		if(action=="") {
			//フォワード
		    forwardPath = "/textbooklist.jsp";
	        RequestDispatcher dispatcher =request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		}

		//「完了」ボタンが押された場合
		else if(action.equals("complete")) {

			//リクエストパラメータを取得
			String textid = request.getParameter("textid");

			//データベースから削除
			Connection conn = null;
			Statement stmt = null;

			try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
					conn = DriverManager.getConnection(url,"master","Pracb2021*");
					stmt = conn.createStatement();

					String sql = "DELETE FROM REGISTER_LIST WHERE TEXTID='"+ textid + "'";
					stmt.executeUpdate(sql);


			}catch(Exception e){
				e.printStackTrace();
			}

			//フォワード
		    forwardPath = "/textbooklist.jsp";
	        RequestDispatcher dispatcher =request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
		}



	}

}
