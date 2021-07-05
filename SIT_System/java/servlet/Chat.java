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

import beans.ChatModel;
import dao.ChatDAO;


@WebServlet("/Chat")

public class Chat extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		String roomID = "";
		String check="";
		String act = req.getParameter("act");

		String studentID = (String)session.getAttribute("loginStudent");
		String friendID = req.getParameter("friendID");
		session.setAttribute("friendID", friendID);

		//データベースからチャット履歴を
		List<ChatModel> chatList = new ArrayList<ChatModel>();
		ChatDAO cd = new ChatDAO();

		if(act.equals("chatLogin")){

			if( studentID.compareTo(friendID) < 0 ) {
				roomID = studentID+friendID;
			} else {
				roomID = friendID+studentID;
			}

			chatList = cd.RequestChat(roomID);

			if(chatList.size() != 0) {
				session.setAttribute("chatlist",chatList);
			}else {
				check = "0";
			}

			session.setAttribute("roomID", roomID);
			req.setAttribute("check", check);
			RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
			dispatcher.forward(req,  res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String roomid = (String)session.getAttribute("roomID");
		String studentid = (String)session.getAttribute("loginStudent");
		ChatDAO cd = new ChatDAO();

		String text = req.getParameter("text");

		if(text != "") {
			cd.InsertChat(roomid,studentid,text);
		}

		List<ChatModel> chatList = cd.RequestChat(roomid);
		session.setAttribute("chatlist", chatList);

		//チャット画面にフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
		dispatcher.forward(req,  res);

	}
}

