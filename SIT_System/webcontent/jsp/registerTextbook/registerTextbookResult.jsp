<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerTextbook.css">
<head>
<meta charset="UTF-8">
<title>教科書登録結果</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<<<<<<< HEAD
<h2>S.I.T_System&nbsp;<span><%= stdid%></span>さん</h2>
=======
<h2>S.I.T_System</h2>
>>>>>>> main
<div class="form-wrapper">
<h1>教科書登録</h1>
<br>
<br>
<div style="text-align:center;">
<p>教科書を登録しました</p>
</div>
<br>
<br>
<br>
<br>
<br>
<form action="/SIT_System/RegisterList" method="get">
<div class="button-panel">
<input type="submit" value="教科書リスト" class="button" >
<input type="hidden" name="action" value="back">
</div>
</form>
<br>
<br>
<br>
<br>
<br>

</div>
</body>
</html>