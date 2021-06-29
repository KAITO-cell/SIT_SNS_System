<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード不一致エラー</title>
</head>
<body>

	<form action="/SIT_System/Home" method="post">
	<p>パスワードとパスワード（確認用）が一致しません</p>
	<br>
	<input type="submit" value="戻る">
	<input type="hidden"  name="act" value="pass">
	
	</form>

</body>
</html>