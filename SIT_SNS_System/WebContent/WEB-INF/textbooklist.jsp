<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>

<!-- 見出し -->
<h1><p style="text-align:center">情報工学科</p></h1>
</head>
<body bgcolor="f0f0f0">
<br>
<br>
<br>

<!-- プルダウン -->
<form method="post" action="/SIT_SNS_System/Request">

<select name="studentid">
      <option value="AL19070">AL19070</option>
      <option value="AL19071">AL19071</option>
      <option value="AL19072">AL19072</option>
      <option value="AL19073">AL19073</option>
      <option value="AL19074">AL19074</option>
</select>


<select name="studentid">
      <option value="AL19070">AL19070</option>
<c:forEach var="i" begin="1" end="5" step="1">
      <option value="i">i</option>
</c:forEach>
<!-- 選択ボタン -->
<input type="submit" value="選択">
</form>
</body>
</html>
<style type="text/css">
h1{
	padding: 1rem;
	background: #33FF33;
}
</style>