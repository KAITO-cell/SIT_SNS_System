<!----------------------------------------------------------------------------------------------------
---File Name	: registerStudentCheck.jsp
---Version		: V1.2
---Designer		: 寺岡 克起
---Date                 : 2021.07.13
---Purpose		: 新規アカウント登録確認画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
---V1.1 : 寺岡 克起	2021.07.01
---V1.2 : 寺岡 克起	2021.07.13
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 必要なパッケージをインポート -->
<%@ page import="beans.StudentModel" %>

<% StudentModel registerUser = (StudentModel) session.getAttribute("registerUser"); %>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">

<!-- タイトル -->
<head>
<meta charset="UTF-8">
<title>アカウント登録確認</title>
</head>


<body bgcolor="#DCDCDC" text="black">

	<!-- 見出し -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>

	<br>
	<br>

	<div class="form-wrapper">
		<h1>新規登録</h1>

		<!-- 入力した情報を表示 -->
		<p>
		学籍番号：<%= registerUser.getStudentID() %><br>
		パスワード：<%= registerUser.getStudentPass() %><br>
		<% if(registerUser.getStudentName() != null && registerUser.getStudentName().length() != 0){ %>
		名前:<%= registerUser.getStudentName() %><br>
		<% }else { %>
		名前:（未入力）<br>
		<% } %>
		</p>
		<p>登録するアカウント情報はお間違いないですか？</p>

		<!-- 入力された情報を登録する -->
		<form action="/SIT_System/RegisterStudent" method="get">
			<div style="text-align:center;">

	 			<!-- 登録ボタン -->
	 			<div class="button-panel">
	      			<input type="submit" class="button" title="touroku" value="登録"></input>
	    		</div>

				<input type="hidden" name="act" value="done">
				<input type="hidden" name="test1" value="${registerUser.getStudentID()}">
				<input type="hidden" name="test2" value="${registerUser.getStudentPass()}">
				<input type="hidden" name="test3" value="${registerUser.getStudentName()}">
			</div>
		</form>

		<!-- アカウント登録画面への遷移リンク -->
		<div class="form-footer">
	    	<p><a href="/SIT_System/RegisterStudent">back</a></p>
	 	</div>

	</div>
</body>
</html>
