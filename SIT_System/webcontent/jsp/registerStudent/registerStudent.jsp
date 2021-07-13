<!----------------------------------------------------------------------------------------------------
---File Name	: registerStudent.jsp
---Version		: V1.2
---Designer		: 寺岡 克起
---Purpose		: 新規アカウント登録画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 寺岡 克起	2021.06.29
---V1.1 : 寺岡 克起	2021.07.01
---V1.2 : 寺岡 克起	2021.07.13
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
	<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>
	<div class="form-wrapper">
  		<h1>新規登録</h1>
  		<form action="/SIT_System/RegisterStudent" method ="post">
	    	<div class="form-item">
	      		<label for="id"></label>
	      		<input type="text" name="id" required="required" placeholder="学籍番号" maxlength="7"minlength="7"></input>
	    	</div>
	    	<div class="form-item">
	      		<label for="password"></label>
	      		<input type="password" name="pass" required="required" placeholder="パスワード" maxlength="8"minlength="6"></input>
	   		</div>
	    	<div class="form-item">
	      		<label for="passcheck"></label>
	      		<input type="password" name="pass_check" required="required" placeholder="パスワード(確認)" maxlength="8"minlength="6"></input>
	    	</div>
	    	<div class="form-item">
	      		<label for="name"></label>
	      		<input type="text" name="name"  placeholder="名前(任意)" maxlength="20"></input>
	    	</div>
	    	<div class="button-panel">
	      		<input type="submit" class="button" title="send" value="登録"></input>
	    	</div>
  		</form>
  		<div class="form-footer">
    		<p><a href="/SIT_System/Login">back</a></p>
  		</div>
	</div>
</html>
