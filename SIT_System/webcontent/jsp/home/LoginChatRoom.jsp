<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">-->
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Loginchat.css">
  <h2>
  	S.I.T_System
  </h2>
  <br>
<div class="choose">
	チャット相手を選択
</div>
	<br>
	<br>
	<br>
  <form action="/SIT_System/Chat" method ="get">
    <div class="cp_iptxt">
		<label class="ef">
      <input type="text" name="friendID" required="required" placeholder="チャット相手の学籍番号"></input>
    </label>
	</div>
	<br>
	<br>
    <div class="button-panel">
      <input type="submit" class="button" title="Sign In" value="選択"></input>
      <input type="hidden" name="act" value="chatLogin">
    </div>
  </form>
  <br>
  <form action="/SIT_System/Home" method="post">
	<input type="submit" value="戻る" class="back">
	<input type="hidden"  name="act" value="back">
	</form>
</html>