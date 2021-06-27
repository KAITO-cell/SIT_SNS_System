<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import = "java.util.*"%>
    <%@ page import = "java.lang.*"%>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>

<!-- 見出し -->
</head>
<body bgcolor="f0f0f0">
<p>情報工学科</p>
<br>

<%int count = Integer.parseInt(request.getAttribute("count"));%>
<%ArrayList<String> studentid = (ArrayList) request.getAttribute("s_id_list");%>

<form method="post" action="/SIT_SNS_System/Request">
<details>
    <summary>教科書名</summary>
    <button type="submit" name="textid" value="6">AL19075</button>
    <button type="submit" name="textid" value="7">AL19076</button>
</details>
</form>

<!-- プルダウン -->
<form method="post" action="/SIT_SNS_System/Request">

<select name="textid">
      <option value="4">AL19073</option>
      <option value="5">AL19074</option>
      <option value="6">AL19075</option>
      <option value="7">AL19076</option>
      <option value="8">AL19077</option>
</select>


<!-- 選択ボタン -->
<input type="submit" value="選択">
</form>
</body>
</html>
