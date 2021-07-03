<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.ChatModel" %>
<%
List<ChatModel> chatlist = (ArrayList<ChatModel>)session.getAttribute("chatlist");
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
		for(int i=0;i<chatlist.size();i++){%>
			<p>
				(<%= chatlist.get(i).getTime() %>

				<%= chatlist.get(i).getStudentID() %>)
				<%= chatlist.get(i).getText() %>
			</p>
<%}} %>
	<form action="/SIT_System/Chat" method="post">
		<p style="text-align:center"><input type="text"  name="text" size="30"></p>
		<p style="text-align:center"><input type="submit" value="送信" class="button"></p>
		<input type="hidden" name="act" value="chat">
	</form>
<br>
<br>
</body>
</html>

<style type="text/css">
.box{width: 40em;border: solid 3px #000}
</style>