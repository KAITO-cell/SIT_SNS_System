<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更完了</title>
</head>
<h2>S.I.T_System&nbsp;<span><%= stdid%></span>さん</h2>
<body>
	<form action="/SIT_System/Home" method="post">
	<br>
	<p>パスワードを変更しました。</p>
	<br>
	<input type="submit" value="ホーム" class="back">
	<input type="hidden" name="act" value="back">

	</form>

</body>
</html>