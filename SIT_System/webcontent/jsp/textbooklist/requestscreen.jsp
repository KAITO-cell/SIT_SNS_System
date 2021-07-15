<!----------------------------------------------------------------------------------------------------
---File Name	        : requestscreen.jsp
---Version		: V1.2
---Designer		: 奈良 操樹
---Date                 : 2021.07.03
---Purpose		: 申請画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 奈良 操樹	2021.06.29
---V1.1 : 奈良 操樹	2021.07.01
---V1.2 : 奈良 操樹	2021.07.03
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 必要なパッケージをインポート -->
    <%@ page import="java.util.ArrayList"%>
    <%@ page import = "java.util.*"%>
    <%@ page import = "java.lang.*"%>
    <%@ page import="beans.TextChatModel" %>
    <%@ page import = "javax.servlet.http.*"%>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/request.css">

<!-- タイトル -->
<head>
<meta charset="UTF-8">
<title>申請画面</title>
</head>

<body>

	<!-- 見出し -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>

	<br>

	<!-- 選択された教科書の情報をテーブルで出力 -->
	<div align=center>
		<div style=display:table; class="table">

			<!-- 学籍番号を表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>学籍番号&emsp; : </div>
				<div style=display:table-cell;>&emsp;<%= session.getAttribute( "s_id" ) %></div>
			</div>

			<!-- 出品者を表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>&emsp;出品者&emsp; : </div>
				<div style=display:table-cell;>&emsp;<%= session.getAttribute( "s_name" ) %></div>
			</div>


			<!-- 教科書名を表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>教科書名&emsp; : </div>
				<div style=display:table-cell;>&emsp; <%= session.getAttribute("t_name") %></div>
			</div>

			<!-- 著者名を表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>&emsp;著者名&emsp; : </div>
				<div style=display:table-cell;>&emsp;<%= session.getAttribute( "author" ) %></div>
			</div>

			<!-- 出版社名を表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>&emsp;出版社&emsp; : </div>
				<div style=display:table-cell;>&emsp;<%= session.getAttribute( "pub" ) %></div>
			</div>

			<!-- キャンパスを表示 -->
			<div style=display:table-row;>
				<div style=display:table-cell;>キャンパス&nbsp; : </div>
				<div style=display:table-cell;>&emsp;<%= session.getAttribute( "cam" ) %></div>
			</div>

		</div>
	</div>
	<br>
	<% if(stdid.equals( (String)session.getAttribute("s_id"))){%>

	<!-- 完了ボタン 登録した生徒の場合-->
	<form method="get" action="/SIT_System/RequestComplete">
		<div style="text-align:center;">
			<input type="submit" value="完了" class="done" onClick="return confirm('本当によろしいですか')">
		</div>
		<input type="hidden" name="action" value="complete">
		<input type="hidden" name="textid" value="<%= session.getAttribute( "t_id" ) %>">
	</form>
	<%}else{ %>

	<!--完了ボタン (登録した生徒ではない場合 ボタンは押せない)-->
	<div style="text-align:center;">
		<button type="submit" disabled class="notdone">完了</button>
	</div>
	<% }%>
	<br>

	<!-- 戻るボタン -->
	<form method="get" action="/SIT_System/RegisterList">
		<input type="submit" value="戻る" class="back">
		<input type="hidden" name="action" value="return">
		<input type="hidden" name="subject" value="<%= (String)request.getAttribute( "subject" ) %>">
	</form>

	<br>
	<br>

	 <!-- チャット履歴があれば、チャット履歴を表示 -->
	 <div class="overflow">
	 	<div class="bg">
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
	   	</div>
	 </div>
	<br>

	<!-- チャットの部分(入力テキスト、送信ボタン) -->
	<form method="post" action="/SIT_System/RequestChat">
		<input type="hidden" name="action" value="return">
		<input type="hidden" name="s_id" value="<%=(String) session.getAttribute( "s_id" ) %>">
		<input type="hidden" name="t_id" value="<%=(String) session.getAttribute( "t_id" ) %>">
		<input type="hidden" name="act" value="sendChat">
		<input type="text" name="text"class="textbox" placeholder ="メッセージを送信...">
		<input type="submit" value="送信" class="send">

		<!-- 更新ボタン(チャット履歴) -->
		<input type="hidden" name="act" value="getChat">
		<input type="submit" value="更新" class="reload">

	</form>
	<br>
	<br>
	<br>
</body>
</html>

