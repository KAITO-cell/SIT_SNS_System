<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.StudentModel" %>
<% StudentModel registerUser = (StudentModel) session.getAttribute("registerUser"); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録確認</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<div style="text-align:center;">
<h2>S.I.T</h2>
</div>
<br>
<br>
<div class="form-wrapper">
<h1>新規登録</h1>
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
<form action="/SIT_System/RegisterStudent" method="get">
<div style="text-align:center;">
 <div class="button-panel">
      <input type="submit" class="button" title="touroku" value="登録"></input>
    </div>
<input type="hidden" name="act" value="done">
<input type="hidden" name="test1" value="${registerUser.getStudentID()}">
<input type="hidden" name="test2" value="${registerUser.getStudentPass()}">
<input type="hidden" name="test3" value="${registerUser.getStudentName()}">
</div>
</form>
<div class="form-footer">
    <p><a href="/SIT_System/RegisterStudent">back</a></p>
  </div>
</div>
</body>
</html>