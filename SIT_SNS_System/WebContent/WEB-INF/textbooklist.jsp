<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>
<h1><p style="text-align:center">情報工学科</p></h1>
</head>
<body bgcolor="f0f0f0">
<br>
<br>
<p>Go to "申請画面"<br>
<a href="requestscreen.jsp" >申請画面</a>
<br>
<%/* <form id="form">
      <select name="select">
      <option value="Hellojsp.jsp">項目1</option>
      <option>項目2</option>
      <option>項目3</option>
      <option>項目4</option>
      <option>項目5</option>
      </select>
</form>*/%>
    <form method="post" action="/SIT_SNS_System/Request">
      <input type="text" name="num1" size="6"> +
      <input type="text" name="num2" size="6">
      <input type="submit" value=" = ">
    </form>
</body>
</html>
<style type="text/css">
h1{
	padding: 1rem;
	background: #33FF33;
}
</style>