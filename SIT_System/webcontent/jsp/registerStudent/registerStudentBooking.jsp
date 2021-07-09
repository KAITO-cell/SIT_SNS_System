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
  <h1>新規登録</h1>
	<p>その学籍番号は既に使用されています。</p>
	 <div class="form-footer">
    <p><a href="/SIT_System/RegisterStudent">back</a></p>
  </div>
</div>
</html>
