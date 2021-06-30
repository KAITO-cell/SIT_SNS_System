<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<!DOCTYPE html>
<html>
  <h2>S.I.T＿System</h2>
<div class="form-wrapper">
  <h1>新規登録</h1>
  <form action="/SIT_System/RegisterStudent" method ="post">
    <div class="form-item">
      <p>名前は20文字以内で入力してください。</p>
    </div>
  </form>
  <div class="form-footer">
    <p><a href="/SIT_System/RegisterStudent">back</a></p>
  </div>
</div>
</html>
