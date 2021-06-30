<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.ChatModel" %>
<% List<ChatModel> chatlist = (ArrayList<ChatModel>)session.getAttribute("chatmodel"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チャット画面</title>
</head>
<body>
<h1><p style="text-align:center">チャット</p></h1>
<br>
<form action="/SIT_System/Chatservlet" method ="post">
<p style="text-align:center"><input type="text"  name="text" size="30"></p>
<p style="text-align:center"><input type="submit" value="送信" class="button"></p>
</form>
<br>
<% for(int i=0;i<chatlist.size();i++){%>
<p>
<%= chatlist.get(i).getTime() %>
(
<%= chatlist.get(i).getStudentid() %>
)
<%= chatlist.get(i).getText() %>
</p>
<%} %>
<br>
<br>
</form>
</body>
</html>

<style type="text/css">
.box{width: 40em;border: solid 3px #000}
</style>