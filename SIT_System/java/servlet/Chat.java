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


@WebServlet("/Chatservlet")

public class Chat extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String studentID = (String)session.getAttribute("loginStudent");
		String friendID = req.getParameter("friendID");
		String roomID = "";
		String act = req.getParameter("act");

		List<ChatModel> chatList = new ArrayList<ChatModel>();
		if(act.equals("chatLogin")){

			//String chatRoomPass = req.getParameter("chatRoomPass");
			if( friendID.compareTo(studentID)<0 ) {
				roomID = friendID+studentID;
			} else {
				roomID = studentID+friendID;
			}
			ChatDAO cd = new ChatDAO();
			chatList = cd.RequestChat(roomID);
			System.out.println(chatList);

			session.setAttribute("chatlist", chatList);

			//チャット画面にフォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
			dispatcher.forward(req,  res);

			//LoginRoomDAO LoginRoom = new LoginRoomDAO();
			//boolean isLogin = LogicRoom.execute(student);
		}



//		textid = "abcdefgh";
//		studentid = "as12345";




	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

//		String roomid = req.getParameter("textid");
//		String studentid = req.getParameter("studentid");
//
//		textid = "abcdefgh";
//		studentid = "as12344";
//
//		String text = req.getParameter("text");
//
//		if(text!="") {
//			ChatDAO insert = new ChatDAO();
//			insert.insertChat(roomid,studentid,text);
//		}
//
//		ChatDAO rc = new ChatDAO();
//		List<TextChatModel> chatList = rc.textRequestChat(textid);
//
//		HttpSession session = req.getSession();
//		session.setAttribute("chatmodel", chatList);
//
//		//チャット画面にフォワード
//		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
//		dispatcher.forward(req,  res);
//
	}

}

