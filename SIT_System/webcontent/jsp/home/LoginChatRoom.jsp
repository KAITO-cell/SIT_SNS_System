<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">-->
<!DOCTYPE html>
<html>
  <h2>
  	S.I.T_System
  </h2>
<div class="form-wrapper">
  <h1>ログイン</h1>
  <form action="/SIT_System/Chat" method ="post">
    <div class="form-item">
      <label for="id"></label>
      <input type="text" name="id" required="required" placeholder="学籍番号"></input>
    </div>
    <div class="button-panel">
      <input type="submit" class="button" title="Sign In" value="こちゃ"></input>
    </div>
  </form>
</div>
</html>
