<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta charset="UTF-8">
<title>申請画面</title>

<!-- 見出し -->
<div style="text-align:center;">
<h1>教科書情報</h1>
</div>
</head>

<br>

<body>
<!-- 選択された教科書の情報をテーブルで出力 -->
<div align=center>
<div style=display:table;>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;出品者&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= request.getAttribute( "s_name" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>教科書名&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= request.getAttribute( "t_name" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;著者名&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= request.getAttribute( "author" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>&emsp;出版社&emsp; : </div>
<div style=display:table-cell;>&emsp;<%= request.getAttribute( "pub" ) %></div>
</div>

<div style=display:table-row;>
<div style=display:table-cell;>キャンパス&nbsp; : </div>
<div style=display:table-cell;>&emsp;<%= request.getAttribute( "cam" ) %></div>
</div>

</div>
</div>
<br>
<!-- 完了ボタン -->
<form method="get" action="/SIT_SNS_System/RequestComplete">
<div style="text-align:center;">
<input type="submit" value="完了" onClick="return confirm('本当によろしいですか')">
</div>
<input type="hidden" name="action" value="complete">
<input type="hidden" name="textid" value="<%= request.getAttribute( "t_id" ) %>">
</form>
<br>

<!-- 戻るボタン -->
<form method="post" action="/SIT_SNS_System/Registerlist">
<input type="submit" value="戻る">
<input type="hidden" name="action" value="return">
<input type="hidden" name="subject" value="<%= request.getAttribute( "subject" ) %>">
</form>
</body>
</html>

<style type="text/css">
h1{
	padding: 1rem;
	background: #33FF33;
}
</style>