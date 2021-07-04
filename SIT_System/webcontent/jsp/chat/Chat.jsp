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
<head>
<meta charset="UTF-8">
<title>チャット画面</title>
</head>
<body>
<h1><p style="text-align:center">チャット</p></h1>
<br>





<br>
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
	<form action="/SIT_System/Chat" method="post">
		<p style="text-align:center"><input type="text"  name="text" size="30"></p>
		<p style="text-align:center"><input type="submit" value="送信" class="button"></p>
		<input type="hidden" name="act" value="chat">
	</form>
<br>
<br>

	<form method="get" action="/SIT_System/Home">
	<input type="hidden" name="act" value="chat">
		<input type="submit" value="戻る">
	</form>

     <form action="/SIT_System/Home" method="get">
	 	<div class="button-panel">
	 		<input type="hidden"  name="act" value="back">
      		<input type="submit" value="ホームへ"></input>
     	</div>
     </form>
</body>
</html>

<style type="text/css">
.box{width: 40em;border: solid 3px #000}
</style>