<!----------------------------------------------------------------------------------------------------
---File Name	        : Setting.jsp
---Version		: V1.1
---Designer		: 樋口 大成
---Date                 : 2021.07.02
---Purpose		: 時間割設定画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 樋口 大成	2021.06.29
---V1.1 : 樋口 大成	2021.07.02
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

<!--タイトル-->
<meta charset="UTF-8">
<title>Setting</title>
</head>
<body>

	<!--見出し-->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>

	<!-- 時間割の編集処理 -->
		<form action="/SIT_System/Home" method="post">

		<!-- 曜日を選択 -->
		<div class="cp_ipselect">
		<select name="state" class="cp_sl06" required>
			<option value="" hidden disabled selected></option>
			<option value="mon">月</option>
			<option value="tue">火</option>
			<option value="wed">水</option>
			<option value="thu">木</option>
			<option value="fri">金</option>
			<option value="sat">土</option>
		</select>
		<span class="cp_sl06_highlight"></span>
		<span class="cp_sl06_selectbar"></span>
		<label class="cp_sl06_selectlabel">曜日を選択</label>
		</div>

		<!-- 選択した曜日の授業を入力 -->
		<table class="original">
		<tbody>
			<tr>
			  <td><input type="text" name="fir" value="" placeholder="1限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="sec" value="" placeholder="2限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="thr" value="" placeholder="3限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="fou" value="" placeholder="4限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="fif" value="" placeholder="5限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="six" value="" placeholder="6限を入力" maxlength="15"></td>
			</tr>
			<tr>
				<td><input type="text" name="sev" value="" placeholder="7限を入力" maxlength="15"></td>
			</tr>
		</tbody></table>

		<!-- 登録ボタン -->
		<div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="登録"></input>
	    </div>
		<input type="hidden"  name="act" value="home">
		</form>

		<br>

		<!-- 戻るボタン -->
		<form action="/SIT_System/Home" method="post">
			<input type="submit" value="戻る" class="back">
			<input type="hidden"  name="act" value="back">
		</form>

</body>
</html>
