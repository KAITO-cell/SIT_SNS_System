<!----------------------------------------------------------------------------------------------------
---File Name	: SettingName.jsp
---Version		: V2.0
---Designer		: 樋口 大成
---Purpose		: 名前設定画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 樋口 大成	2021.06.29
---V1.1 : 樋口 大成	2021.06.30
---V1.2 : 樋口 大成	2021.07.02
---
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<html>
<head>
<!--タイトル-->
<meta charset="UTF-8">
<title>名前変更</title>
</head>
<body>

<!--見出し-->
<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>
<br>

<!-- 名前変更処理 -->
<div class="title">名前を変更</div>
	<form action="/SIT_System/Home" method="post">

		<!-- 名前入力欄 -->
		<div class="cp_iptxt">
			<label class="ef">
				<input type="text" name="name" maxlength="20" placeholder="名前を入力"><br>
			</label>
		</div>
		<p>※名前は20文字以内で入力</p>

		<!-- 登録ボタン -->
		<div class="button-panel">
      		<input type="submit" class="button" title="Change" value="登録"></input>
    	</div>
    	<input type="hidden"  name="act" value="nameChange">
	</form>
	<br>

	<!-- 戻るボタン -->
	<form action="/SIT_System/Home" method="post">
		<input type="submit" value="戻る" class="back">
		<input type="hidden"  name="act" value="back">
	</form>

</body>
</html>