<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Student" %>
<%
Student registerUser = (Student) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学籍番号登録確認</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<div style="text-align:center;">
<p>新規アカウント登録</p>
</div>
<br>
<br>
<p>
学籍番号：<%= registerUser.getId() %><br>
パスワード：<%= registerUser.getPass() %><br>
名前:<%= registerUser.getName() %><br>
</p>
<p>登録するアカウント情報はお間違いないですか？</p>
<a href="/新規アカウント登録/RegisterStudent">戻る</a>
<a href="/新規アカウント登録/RegisterStudent?act=done">送信</a>
<form action="/新規アカウント登録/RegisterStudent" method="get">
<div style="text-align:center;">
<input type="submit" value="送信" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
<input type="hidden" name="act" value="done">
</div>
</form>
<br>
<form action="/新規アカウント登録/RegisterStudent" method="get">
<div style="text-align:center;">
<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
</div>
</form>
</body>
</html>