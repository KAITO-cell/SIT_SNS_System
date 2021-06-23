<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学籍番号登録</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<form action="/SIT_SNS_System/RegisterStudent" method="post">
<div style="text-align:center;">
<h1>新規アカウント登録</h1>
</div>
<p>アカウントを登録します</p>
<p>学籍番号：<input type="text" name="id"><br></p>
<p>パスワード：<input type="password" name="pass"><br></p>
<p>パスワード（確認用）：<input type="password" name="pass_check"><br></p>
<p>名前（任意）：<input type="text" name="name"><br></p>
<p>※学籍番号は英数字７文字、アルファベットは半角大文字、数字は半角で入力</p>
<p>※パスワードは半角英数字６～８文字で入力</p>
<p>※名前は任意だが、20文字以内で入力</p>
<br>
<div style="text-align:center;">
<input type="submit" value="確認" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
</div>
</form>
<form action="/SIT_SNS_System/SIT_SNS_system_login" method="get">
<div style="text-align:center;">
<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
</div>
</form>
</body>
</html>
