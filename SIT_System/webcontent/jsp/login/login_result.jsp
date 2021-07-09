<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
  <h2>S.I.T_System&nbsp;<span><%= stdid%></span>さん</h2>
<div class="form-wrapper">
  <h1>ログイン</h1>
  <p>学籍番号またはパスワードが正しくありません。</p>
  <div class="form-footer">
    <p><a href="/SIT_System/Login">Back</a></p>
  </div>
</div>
</html>
