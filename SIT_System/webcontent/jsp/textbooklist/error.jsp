<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>
</head>

<body>
<!-- 見出し -->
<div align="center">情報工学科</div>
<br>
<br>
<!-- エラー文 -->
<div align="center">エラーが発生しました</div>
<br>

<!-- 確認ボタン -->
<div align="center">
<form method="get" action="/SIT_System/Registerlist">
<input type="submit" value="確認">
<input type="hidden" name="action" value="error_ok">
</form>
</div>
</body>

</html>
