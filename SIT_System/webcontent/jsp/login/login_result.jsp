<!----------------------------------------------------------------------------------------------------
---File Name	: login_result.jsp
---Version		: V.0
---Designer		: 樋口 大成
---Purpose		: ログイン不可画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 樋口 大成	2021.06.27
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
	<!-- 見出し -->
	<h2>S.I.T_System</h2>

	<!-- エラーメッセージ表示 -->
	<div class="form-wrapper">
  		<h1>ログイン</h1>
  		<p>学籍番号またはパスワードが正しくありません。</p>

  		<!-- ログイン画面遷移リンク -->
  		<div class="form-footer">
    		<p><a href="/SIT_System/Login">Back</a></p>
  		</div>

	</div>
</html>
