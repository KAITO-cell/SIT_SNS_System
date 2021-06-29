<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
</head>
<body>

	<form action="/SIT_System/Home" method="post">
	<p>パスワード：<input type="text" name="pass"><br></p>
    <p>パスワード（確認用）：<input type="text" name="pass_check"><br></p>
    <p>※パスワードは半角英数字６～８文字で入力</p>
	<input type="submit" value="変更">
	<input type="hidden"  name="act" value="passChange">
	</form>
	<br>
	<form action="/SIT_System/Home" method="post">
	<input type="submit" value="戻る">
	<input type="hidden"  name="act" value="back">
	
	</form>

</body>
</html>