<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
</head>
<body>
	<h2>S.I.T_System</h2>
	<br>
	<div class="title">パスワードを変更</div>
	<form action="/SIT_System/Home" method="post">
	<br>
	<div class="cp_iptxt">
	<label class="ef">
	<input type="text" name="pass" placeholder="パスワード" minlength="6" maxlength="8"　required><br>
	<br>
    <input type="text" name="pass_check"placeholder="パスワード(確認用)"minlength="6" maxlength="8" reiquired><br>
    </label>
    </div>
    <p>※パスワードは半角英数字６～８文字で入力</p>
    <br>
	<div class="button-panel">
      <input type="submit" class="button" title="Change" value="登録"></input>
    </div>
	<input type="hidden"  name="act" value="passChange">
	</form>
	<br>
	<form action="/SIT_System/Home" method="post">
	<input type="submit" value="戻る" class="back">
	<input type="hidden"  name="act" value="back">
	</form>
</body>
</html>
