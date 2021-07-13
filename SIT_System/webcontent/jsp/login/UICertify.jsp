<!----------------------------------------------------------------------------------------------------
---File Name	: UICertrify.jsp
---Version		: V1.2
---Designer		: 樋口 大成
---Date                 : 2021.07.02
---Purpose		: ログイン画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 樋口 大成	2021.06.05
---V1.1 : 樋口 大成	2021.07.01
---V1.2 : 樋口 大成	2021.07.02
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>

<!--見出し-->
<h2>S.I.T_System</h2>

<!--  -->
<div class="form-wrapper">
	<h1>ログイン</h1>
  	<form action="/SIT_System/Login" method ="post">

    	<!-- 学籍番号入力 -->
    	<div class="form-item">
      		<label for="id"></label>
      			<input type="text" name="id" required="required" placeholder="学籍番号"maxlength="7"minlength="7"></input>
    	</div>

    	<!-- パスワード入力 -->
    	<div class="form-item">
      		<label for="password"></label>
      		<input type="password" name="pass" required="required" placeholder="パスワード" maxlength="8"minlength="6"></input>
    	</div>

    	<!-- ログインボタン -->
    	<div class="button-panel">
      		<input type="submit" class="button" title="Sign In" value="ログイン"></input>
    	</div>

	</form>

	<!-- アカウント登録への遷移リンク -->
	<div class="form-footer">
    	<p><a href="/SIT_System/RegisterStudent">Create an account</a></p>
	</div>

</div>
</html>
