<!----------------------------------------------------------------------------------------------------
---File Name	: SettingPass.jsp
---Version		: V1.1
---Designer		: 寺岡 克起
---Date                 : 2021.07.01
---Purpose		: パスワード設定画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
---V1.1 : 寺岡 克起	2021.07.01
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<head>

<!-- タイトル -->
<meta charset="UTF-8">
<title>パスワード変更</title>
</head>
<body>

	<!-- 見出し -->
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>
	<br>

	<div class="title">パスワードを変更</div>
	<form action="/SIT_System/Home" method="post">
		<br>
		<div class="cp_iptxt">
		<label class="ef">

			<!-- パスワード入力欄 -->
			<input type="text" name="pass" placeholder="パスワード" minlength="6" maxlength="8" required><br>
			<br>

    		<!-- パスワード(確認用)入力欄 -->
    		<input type="text" name="pass_check"placeholder="パスワード(確認用)"minlength="6" maxlength="8" required><br>
    	</label>
    	</div>
    	<p>※パスワードは半角英数字６～８文字で入力</p>
    	<br>

		<!-- 登録ボタン -->
		<div class="button-panel">
      		<input type="submit" class="button" title="Change" value="登録"></input>
    	</div>
		<input type="hidden"  name="act" value="passChange">
	</form>
	<br>

	<!-- 戻るボタン -->
	<form action="/SIT_System/Home" method="post">
		<input type="submit" value="戻る" class="back">
		<input type="hidden"  name="act" value="back">
	</form>
</body>
</html>
