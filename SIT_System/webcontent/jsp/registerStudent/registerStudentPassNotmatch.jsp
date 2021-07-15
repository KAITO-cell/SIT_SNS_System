<!----------------------------------------------------------------------------------------------------
---File Name	: registerStudentPassNotmatch.jsp
---Version		: V1.1
---Designer		: 寺岡 克起
---Date                 : 2021.07.13
---Purpose		: 新規アカウント登録パスワード不一致画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
---V1.1 : 寺岡 克起	2021.07.13
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">

	<!-- ログイン中の生徒の情報 -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>

	<!-- エラー内容を表示 -->
	<div class="form-wrapper">
  		<h1>新規登録</h1>
		<p>パスワードとパスワード(確認用)が一致しません。</p>

	 	<!-- アカウント登録画面への遷移リンク -->
	 	<div class="form-footer">
    		<p><a href="/SIT_System/RegisterStudent">back</a></p>
  		</div>

	</div>
</html>
