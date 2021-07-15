<!----------------------------------------------------------------------------------------------------
---File Name	: registerTextbookOrNull.jsp
---Version		: V1.2
---Designer		: 福田 怜哉
---Date         : 2021.07.13
---Purpose		: 教科書登録エラー画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 福田 怜哉	2021.06.29
---V1.1 : 福田 怜哉	2021.07.01
---V1.2 : 福田 怜哉	2021.07.13
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
<title>教科書登録エラー</title>
</head>

<body bgcolor="#DCDCDC" text="black">

	<!-- 見出し -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>
	<form action="/SIT_System/RegisterTextbook" method="get">
		<div class="form-wrapper">
		<h1>教科書登録</h1>
		<br>
		<br>

		<!-- エラーメッセージを表示 -->
		<div style="text-align:center;">
			<p>入力されていない項目があります</p>
		</div>

		<br>

		<!-- 戻るボタン -->
		<div style="text-align:center;">
			<input type="submit" value="戻る" class="back">
		</div>

		<br>
		<br>
		</div>
	</form>
</body>
</html>
