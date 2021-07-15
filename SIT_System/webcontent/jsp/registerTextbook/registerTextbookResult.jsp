<!----------------------------------------------------------------------------------------------------
---File Name	: registerTextbookResult.jsp
---Version		: V1.1
---Designer		: 福田 怜哉
---Date                 : 2021.07.01
---Purpose		: 教科書登録結果画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 福田 怜哉	2021.06.29
---V1.1 : 福田 怜哉	2021.07.01
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerTextbook.css">

<!-- タイトル -->
<head>
<meta charset="UTF-8">
<title>教科書登録結果</title>
</head>

<body bgcolor="#DCDCDC" text="black">

	<!-- 見出し -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>

	<!-- 結果を表示 -->
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

		<!-- 教科書リストへの遷移ボタン -->
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
