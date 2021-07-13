<!----------------------------------------------------------------------------------------------------
---File Name	        : error.jsp
---Version		: V1.0
---Designer		: 奈良 操樹
---Date                 : 2021.06.29
---Purpose		: エラー画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 奈良 操樹	2021.06.29
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/request.css">

<!-- タイトル -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>エラー画面</title>
</head>

<body>
	<!-- 見出し -->
	<div align="center">Error</div>
	<br>
	<br>
	<!-- エラー文 -->
	<div align="center">エラーが発生しました</div>
	<br>

	<!-- 確認ボタン -->
	<div align="center">
		<form method="get" action="/SIT_System/RegisterList">
		<input type="submit" value="確認">
		<input type="hidden" name="action" value="error_ok">
		</form>
	</div>
</body>

</html>
