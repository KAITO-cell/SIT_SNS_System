<!----------------------------------------------------------------------------------------------------
---File Name	: SettingPassNotmatch.jsp
---Version		: V1.0
---Designer		: 寺岡 克起
---Purpose		: パスワード設定不一致画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">

<!-- タイトル -->
<head>
<meta charset="UTF-8">
<title>パスワード不一致エラー</title>
</head>
<body>

	<!-- 見出し -->
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>
	<br>

	<form action="/SIT_System/Home" method="post">
		<p>パスワードとパスワード（確認用）が一致しません</p>
		<br>
		<!-- 戻るボタン -->
		<input type="submit" value="戻る" class="back">
		<input type="hidden"  name="act" value="pass">
	</form>
</body>
</html>
