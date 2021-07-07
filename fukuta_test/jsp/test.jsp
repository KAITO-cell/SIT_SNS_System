<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/fukuta_test/test_a" method ="post">

			<p style="text-align:center">学籍番号:   <input type="text" name="id"></p><br>
			<p style="text-align:center">パスワード: <input type="password" name="pass"></p><br>
			<br>
			<p style="text-align:center"><input type="checkbox" id="01-A" name="checkbox01" checked="checked">ログインしたままにする</p> 
			<br>
			<br>
			<p style="text-align:center"><input type="submit" value="ログイン" class="button"></p>
		</form>

</body>
</html>