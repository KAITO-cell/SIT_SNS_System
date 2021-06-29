<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名前変更</title>
</head>
<body>

	<form action="/SIT_System/Home" method="post">
	<p>名前：<input type="text" name="name"><br></p>
	<p>※名前は20文字以内で入力</p>
	<input type="submit" value="変更">
	<input type="hidden"  name="act" value="nameChange">
	</form>
	<br>
	<form action="/SIT_System/Home" method="post">
	<input type="submit" value="戻る">
	<input type="hidden"  name="act" value="back">
	
	</form>

</body>
</html>