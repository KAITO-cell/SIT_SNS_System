<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名前変更完了</title>
</head>
<body>
	<h2>S.I.T_System</h2>
	<form action="/SIT_System/Home" method="post">
	<p>名前を変更しました</p>
	<br>
	<input type="submit" value="ホーム">
	<input type="hidden" name="act" value="back">

	</form>

</body>
</html>