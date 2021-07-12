
/**************************************************************************************************
 ***  File Name      : RegisterTextbook.java
 ***  Version        : V1.4
 ***  Designer       : 福田
 ***  Date           : 2021.07.09
 ***  Purpose        : ログインした学籍番号に基づく時間割を表示させる。
 ***                   設定画面、教科書リスト画面、チャット画面へ遷移させる。
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 永井海音,2021.06.17
 *** V1.1 : 永井海音,2021.06.20
 *** V1.2 : 永井海音,2021.06.25
 *** V1.3 : 永井海音,2021.07.02
 *** V1.4 : 永井海音,2021.07.09
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RegisterListModel;
import dao.RegisterListDAO;

@WebServlet("/RegisterTextbook")
public class RegisterTextbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		//変数の準備
        String forwardPath = "";

        // サーブレットクラスの動作を決定する「action」の値を
	    // リクエストパラメータから取得
	    String action = request.getParameter("act");

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String studentId = request.getParameter("test1");
	    String studentName = request.getParameter("test2");
	    String department = request.getParameter("test3");
	    String subject = request.getParameter("test4");
	    String textName = request.getParameter("test5");
	    String author = request.getParameter("test6");
	    String publisher = request.getParameter("test7");
	    String campus = request.getParameter("test8");

	    // 登録する教科書の情報を設定
	    RegisterListModel registertextbook = new RegisterListModel(studentId,studentName,department,subject,textName,author,publisher,campus);

	    //「登録の開始」をリクエストされたときの処理
	    if (action == null) {
	      // フォワード先を設定
	      forwardPath = "/jsp/registerTextbook/registerTextbook.jsp";

	    }

	    // 登録確認画面から「登録実行」をリクエストされたときの処理
	    else if (action.equals("done")) {

	      // セッションスコープに保存された登録ユーザ
	      HttpSession session = request.getSession();
		  session.setAttribute("registerTextbook", registertextbook);

	      // 登録処理の呼び出し
	      RegisterListDAO textDao = new RegisterListDAO();
	      textDao.registerMyTextList(registertextbook);

	      // 不要となったセッションスコープ内のインスタンスを削除
	      session.removeAttribute("registertextbook");
	      session.removeAttribute("registerTextbook");

	      // 登録後のフォワード先を設定
	      forwardPath = "/jsp/registerTextbook/registerTextbookResult.jsp";
	    }

	    // 設定されたフォワード先にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
	}


	  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

		// フォワード先
		String forwardPath = "";

		// リクエストパラメータの取得
		HttpSession session2 = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    String studentId = (String)session2.getAttribute("loginStudent");
	    String studentName = request.getParameter("studentname");
	    String department = request.getParameter("department");
	    String subject = request.getParameter("subject");
	    String textName = request.getParameter("textname");
	    String author = request.getParameter("authorname");
	    String publisher = request.getParameter("publishername");
	    String campus = request.getParameter("campus");

	    // 登録する教科書の情報を設定
	 	RegisterListModel registertextbook = new RegisterListModel(studentId,studentName,department,subject,textName,author,publisher,campus);

	 	//レコードに空欄があるか確認
	    if(studentName.length() == 0 || department.length() == 0 || subject.length() == 0 ||
	    		textName.length() == 0 ||author.length() == 0 ||publisher.length() == 0 || campus.length() == 0 ) {
	    	forwardPath = "/jsp/registerTextbook/registerTextbookOrNull.jsp";
	    } else {
	    	forwardPath = "jsp/registerTextbook/registerTextbookCheck.jsp";

	    	HttpSession session = request.getSession();
			  session.setAttribute("registerTextbook", registertextbook);
	    }

	    // 設定されたフォワード先にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
	  }
}


