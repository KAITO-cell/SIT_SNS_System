<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ page import="beans.StudentModel" %>
<% StudentModel registerUser = (StudentModel) session.getAttribute("registerUser"); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録確認</title>
</head>
<body bgcolor="#DCDCDC" text="black">
	<div style="text-align:center;">
	<h1>新規アカウント登録</h1>
	</div>
	<br>
	<br>
	<p>
	学籍番号：<%= registerUser.getStudentID() %><br>
	パスワード：<%= registerUser.getStudentPass() %><br>
	<% if(registerUser.getStudentName() != null && registerUser.getStudentName().length() != 0){ %>
	名前:<%= registerUser.getStudentName() %><br>
	<% }else { %>
	名前:（未入力）<br>
	<% } %>
	</p>
	<p>登録するアカウント情報はお間違いないですか？</p>
	<form action="/SIT_System/RegisterStudent" method="get">
		<div style="text-align:center;">
		<input type="submit" value="送信" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
		<input type="hidden" name="act" value="done">
		<input type="hidden" name="test1" value="${registerUser.getStudentID()}">
		<input type="hidden" name="test2" value="${registerUser.getStudentPass()}">
		<input type="hidden" name="test3" value="${registerUser.getStudentName()}">
		</div>
	</form>
	<form action="/SIT_System/RegisterStudent" method="get">
		<div style="text-align:center;">
		<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
		</div>
	</form>
</body>
</html>