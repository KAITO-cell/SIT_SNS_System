<!----------------------------------------------------------------------------------------------------
---File Name	: SettingNameResult.jsp
---Version		: V1.0
---Designer		: 樋口 大成
---Purpose		: 名前変更確認画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 樋口 大成	2021.06.29
---
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<head>

<!--タイトル-->
<meta charset="UTF-8">
<title>名前変更完了</title>
</head>
<body>

	<!--見出し-->
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>

	<!-- ホーム遷移ボタン -->
	<form action="/SIT_System/Home" method="post">
		<p>名前を変更しました</p>
		<br>
		<input type="submit" value="ホーム">
		<input type="hidden" name="act" value="back">
	</form>

</body>
</html>
