<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/setting.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名前変更</title>
</head>
<body>
<h2>S.I.T_System</h2>
<br>
<div class="title">名前を変更</div>
	<form action="/SIT_System/Home" method="post">
	<div class="cp_iptxt">
	<label class="ef">
	<input type="text" name="name" maxlength="20" placeholder="名前を入力"><br>
	</label>
	</div>
	<p>※名前は20文字以内で入力</p>
	<div class="button-panel">
      <input type="submit" class="button" title="Change" value="登録"></input>
    </div>
	</form>
	<br>
	<form action="/SIT_System/Home" method="post">
	<input type="submit" value="戻る" class="back">
	<input type="hidden"  name="act" value="back">
	</form>

</body>
</html>
