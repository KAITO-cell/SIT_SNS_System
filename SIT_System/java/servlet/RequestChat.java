/**************************************************************************************************
 ***  File Name      : RequestChat.java
 ***  Version        : V1.2
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.03
 ***  Purpose        : データベースからチャット履歴を取得し、セッションに登録する。
 ***                   申請画面で入力されたテキストをデータベースに登録する。
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.29
 *** V1.1 : 奈良操樹,2021.07.02
 *** V1.2 : 奈良操樹,2021.07.03
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.TextChatModel;
import dao.ChatDAO;

/**
 * Servlet implementation class RequestChat
 */
@WebServlet("/RequestChat")
public class RequestChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//エンコーディング
		request.setCharacterEncoding("UTF-8");

		//どこから来たのかを確認
		String act = (String)request.getParameter("act");

		//判定
		if(act==null) {
			act="getChat";
		}

		//セッションIDを取得
		HttpSession session = request.getSession();

		//変数の準備
		String textID = (String)session.getAttribute("t_id");                //登録されている教科書のID
		String chattext;                                                     //入力したテキスト
		String studentID = (String)session.getAttribute("loginStudent");    //ログインしてる学生の学籍番号

		//処理別判定
		if(act.equals("sendChat")){

			//送信されたテキストを取得
			chattext= request.getParameter("text");

			//送信されたテキストがあれば、データベースに登録
			ChatDAO cd = new ChatDAO();;
			if(chattext!="") {
			    cd.textInsertChat(textID,studentID,chattext);
			}

			//変数の準備
			String check="1";
			List<TextChatModel> chatList= new ArrayList<TextChatModel>();

			//チャット履歴を取得し、セッションに登録
			chatList = cd.textRequestChat(textID);
			session.setAttribute("chatlist",chatList);
			request.setAttribute("check", check);

			//申請画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/textbooklist/requestscreen.jsp");
			dispatcher.forward(request,  response);

	    }else if(act.equals("getChat")) {

	    	//変数準備
			List<TextChatModel> chatList= new ArrayList<TextChatModel>();
			String check="1";

			//データベースにあるチャット履歴を取得
			ChatDAO cd = new ChatDAO();
			chatList = cd.textRequestChat(textID);

			//チャット履歴があればセッションに登録、なければ登録しない
			if(chatList.size()!=0) {
				session.setAttribute("chatlist",chatList);
			}else {
				check = "0";
			}

			//チャット履歴があるかどうかの判定を送る
			request.setAttribute("check", check);

			//申請画面に遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/textbooklist/requestscreen.jsp");
			dispatcher.forward(request,  response);
	   }

   }
}
