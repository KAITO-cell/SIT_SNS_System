<!----------------------------------------------------------------------------------------------------
---File Name	: SettingPassResult.jsp
---Version		: V1.0
---Designer		: 寺岡 克起
---Purpose		: パスワード設定確認画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">

<!-- タイトル -->
<head>
<meta charset="UTF-8">
<title>パスワード変更完了</title>
</head>
<body>

	<!-- タイトル -->
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>


	<form action="/SIT_System/Home" method="post">
		<br>
		<p>パスワードを変更しました。</p>
		<br>
		<!-- ホームボタン -->
		<input type="submit" value="ホーム" class="back">
		<input type="hidden" name="act" value="back">
	</form>
</body>
</html>
