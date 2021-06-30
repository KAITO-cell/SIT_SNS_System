package servlet;


import java.io.IOException;
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

public class Chatservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String act = req.getParameter("act");
		
		if(act.equals("chatLogin")){
			String chatRoomId = req.getParameter("chatRoomId");
			String chatRoomPass = req.getParameter("chatRoomPass");
			
			//LoginRoomDAO LoginRoom = new LoginRoomDAO();
			//boolean isLogin = LogicRoom.execute(student);
		}
		
		String textid = req.getParameter("textid");
		String studentid = (String)session.getAttribute("loginStudent");
		
		textid = "abcdefgh";
		studentid = "as12345";
		
		ChatDAO contents = new ChatDAO();
		List<ChatModel> chatList = contents.requestChat(textid);
		System.out.println(chatList);
		
		session.setAttribute("chatmodel", chatList);
		
		//チャット画面にフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
		dispatcher.forward(req,  res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		
		String textid = req.getParameter("textid");
		String studentid = req.getParameter("studentid");
		
		textid = "abcdefgh";
		studentid = "as12344";
		
		String text = req.getParameter("text");
		
		if(text!="") {
			ChatDAO insert = new ChatDAO();
			insert.insertChat(textid,studentid,text);
		}
		
		ChatDAO rc = new ChatDAO();
		List<ChatModel> chatList = rc.requestChat(textid);
		
		HttpSession session = req.getSession();
		session.setAttribute("chatmodel", chatList);
		
		//チャット画面にフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/chat/Chat.jsp");
		dispatcher.forward(req,  res);
		
	}
	
}

