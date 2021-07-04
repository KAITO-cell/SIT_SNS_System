<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import = "java.util.*"%>
    <%@ page import = "java.lang.*"%>
    <%@ page import="beans.TextChatModel" %>
    <%@ page import = "javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta charset="UTF-8">
<title>申請画面</title>

<!-- 見出し -->
<div style="text-align:center;">
<h1>教科書情報</h1>
</div>
</head>
<br>

<body>
<!-- 選択された教科書の情報をテーブルで出力 -->
<div align=center>
<div style=display:table;>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;出品者&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= session.getAttribute( "s_name" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>教科書名&emsp; : </div>
<div style=display:table-cell;>&emsp; <%= session.getAttribute("t_name") %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;著者名&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= session.getAttribute( "author" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;出版社&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= session.getAttribute( "pub" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>キャンパス&nbsp; : </div>
<div style=display:table-cell;>&emsp;<%= session.getAttribute( "cam" ) %></div>
</div>

</div>
</div>
<br>
<%String stdid = (String)session.getAttribute("loginStudent"); System.out.print(stdid);%>
<% if(stdid.equals( (String)session.getAttribute("s_id"))){%>
<!-- 完了ボタン 登録した生徒の場合-->
<form method="get" action="/SIT_System/RequestComplete">
<div style="text-align:center;">
<input type="submit" value="完了" onClick="return confirm('本当によろしいですか')">
</div>
<input type="hidden" name="action" value="complete">
<input type="hidden" name="textid" value="<%= session.getAttribute( "t_id" ) %>">
</form>
<%}else{ %>
<!--完了ボタン (登録した生徒ではない場合 ボタンは押せない)-->
<div style="text-align:center;">
<button type="submit" disabled>完了</button>
</div>
<% }%>
<br>

<!-- 戻るボタン -->
<form method="get" action="/SIT_System/RegisterList">
<input type="submit" value="戻る">
<input type="hidden" name="action" value="return">
<input type="hidden" name="subject" value="<%= (String)request.getAttribute( "subject" ) %>">
</form>

<br>
<br>

 <!-- チャット履歴があれば、チャット履歴を表示 -->
    <% String check =(String)request.getAttribute("check");%>
    <% if(check!="0"){
    	List<TextChatModel> chatlist = (ArrayList<TextChatModel>)session.getAttribute("chatlist");
		for(int i=0;i<chatlist.size();i++){
			if(chatlist.get(i).getStudentid().equals((String)session.getAttribute("s_id"))){
		%>
			<p style="text-align:right">
				(<%= chatlist.get(i).getTime() %>
				<%= chatlist.get(i).getStudentid() %>)
				<%= chatlist.get(i).getText() %>
			</p>
			<%}else{ %>
			<p style="text-align:left">
				(<%= chatlist.get(i).getTime() %>
				<%= chatlist.get(i).getStudentid() %>)
				<%= chatlist.get(i).getText() %>

			</p>
             <%} %>
        <%} %>
   <%}%>
<br>
<!-- チャットの部分(入力テキスト、送信ボタン) -->
<form method="post" action="/SIT_System/RequestChat">
<input type="hidden" name="action" value="return">
<input type="hidden" name="s_id" value="<%=(String) session.getAttribute( "s_id" ) %>">
<input type="hidden" name="t_id" value="<%=(String) session.getAttribute( "t_id" ) %>">
<input type="hidden" name="act" value="sendChat">
<p style="text-align:center"><input type="text" name="text" size="30">
<input type="submit" value="送信">
</p>
</form>
<br>
<!-- 更新ボタン(チャット履歴) -->
<form method="post" action="/SIT_System/RequestChat">
<input type="hidden" name="act" value="getChat">
<input type="submit" value="更新">
</form>
<br>
<br>
</body>
</html>

<style type="text/css">
h1{
	padding: 1rem;
	background: #33FF33;
}
</style>