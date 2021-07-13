<!----------------------------------------------------------------------------------------------------
---File Name	: registerStudentResult.jsp
---Version		: V2.0
---Designer		: 寺岡 克起
---Purpose		: 新規アカウント登録確認画面
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">

	<!-- 見出し -->
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>

	<!-- エラー内容を表示 -->
	<div class="form-wrapper">
  		<h1>新規登録</h1>
		<p>アカウントを登録しました。</p>

	 	<!-- ログイン画面への遷移リンク -->
	 	<div class="form-footer">
   			<p><a href="/SIT_System/Login">back</a></p>
  		</div>

	</div>
</html>
