<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.ChatModel" %>
<%
List<ChatModel> chatlist = (ArrayList<ChatModel>)session.getAttribute("chatlist");
String friendID=(String)session.getAttribute("friendID");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/chat.css">
<head>
<meta charset="UTF-8">
<title>チャット画面</title>
</head>
<body>
<h2>S.I.T_System</h2>
<h1><p style="text-align:center">チャット</p></h1>
<br>





<br>
<div class="overflow">
<%
	String check = (String)request.getAttribute("check");
	if(check!="0"){
		for(int i=0;i<chatlist.size();i++){
			if(chatlist.get(i).getStudentID().equals(friendID)){
		%>
			<p style="text-align:left">
				(<%= chatlist.get(i).getTime() %>
				<%= chatlist.get(i).getStudentID() %>)
				<%= chatlist.get(i).getText() %>
			</p>
			<%}else{ %>
			<p style="text-align:right">
				(<%= chatlist.get(i).getTime() %>
				<%= chatlist.get(i).getStudentID() %>)
				<%= chatlist.get(i).getText() %>

			</p>
<%}}} %>
</div>
	<br>
	<div class="line_container">
	<form action="/SIT_System/Chat" method="post">
		<div class="line"><input type="text"  name="text" size="30" placeholder="メッセージを送信..." class="textbox">
		<input type="submit" value="送信" class="send">
		<input type="hidden" name="act" value="chat">
		<input type="hidden" name="act" value="getChat">
		<input type="submit" value="更新" class="reload">
		</div>
	</form>
	<form method="get" action="/SIT_System/Home">
		<div class="line"><input type="hidden" name="act" value="chat" >
		<input type="submit" value="戻る" class="back_chat">
		</div>
	</form>
	</div>
<br>
<br>
</body>
</html>

