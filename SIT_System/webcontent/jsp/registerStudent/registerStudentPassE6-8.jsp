<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録エラー</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<form action="/SIT_System/RegisterStudent" method="get">
<div style="text-align:center;">
<h1>新規アカウント登録</h1>
</div>
<br>
<br>
<p>パスワードは半角英数字６～８文字で入力してください</p>
<br>
<div style="text-align:center;">
<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
</div>
</form>
</body>
</html>