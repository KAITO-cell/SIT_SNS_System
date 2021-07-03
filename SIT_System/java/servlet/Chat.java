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

		HttpSession session = req.getSession();

		String studentID = (String)session.getAttribute("loginStudent");
		String friendID = req.getParameter("friendID");
		session.setAttribute("friendID", friendID);
//		String studentID = "AL12345";
//		String friendID = "AL19046";
		String roomID = "";
		//String act = req.getParameter("act");
		String act="chatLogin";
		//System.out.println(friendID+"myID"+studentID);
		List<ChatModel> chatList = new ArrayList<ChatModel>();
		ChatDAO cd = new ChatDAO();


		System.out.println(roomID);
		if(act.equals("chatLogin")){

			//String chatRoomPass = req.getParameter("chatRoomPass");
			if( studentID.compareTo(friendID) < 0 ) {

				roomID = studentID+friendID;

			} else {
				roomID = friendID+studentID;

			}
			chatList = cd.RequestChat(roomID);
			String check="";
			if(chatList.size()!=0) {
				session.setAttribute("chatlist",chatList);
			}else {
				check = "0";
			}

			//chatList = cd.RequestChat(roomID);

//			if(chatList.get(0).getRoomID()!=null) {
//				System.out.println(chatList);
//			}else {
//				cd.initChatRoom(roomID);
//				chatList = cd.RequestChat(roomID);
//			}

			session.setAttribute("roomID", roomID);
			req.setAttribute("check", check);
			//session.setAttribute("studentID", studentID);
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



		HttpSession session = req.getSession();
		String roomid = (String)session.getAttribute("roomID");
		String studentid = (String)session.getAttribute("loginStudent");
		ChatDAO cd = new ChatDAO();

		System.out.println("post"+roomid+studentid);

		String text = req.getParameter("text");

		if(text!="") {
			cd.InsertChat(roomid,studentid,text);
		}


		List<ChatModel> chatList = cd.RequestChat(roomid);
		session.setAttribute("chatlist", chatList);
		//チャット画面にフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
		dispatcher.forward(req,  res);

	}

}

