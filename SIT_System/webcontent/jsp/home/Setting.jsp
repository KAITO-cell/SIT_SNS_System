<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
	String[] period = (String[]) session.getAttribute("period");
	String[] test = new String[48];
	System.out.println(period[1]);
	System.out.println(period[2]);
	System.out.println(period[3]);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting</title>
</head>
<body>

	<form action="/sit_sns_system/Home" method="post">
<table><tbody>

	<tr>
		<th></th>
		<th class=throriginalclass>月</th>
		<th class=throriginalclass>火</th>
		<th class=throriginalclass>水</th>
		<th class=throriginalclass>木</th>
		<th class=throriginalclass>金</th>
		<th class=throriginalclass>土</th>
	</tr>

	<% int time = 1,count=0; for(int j=0;j<7;j++){ %>
	<tr>
		<td><%= time++ %>限目</td>
		<% for(int i =0;i<6;i++){%>
		<td><input type="text" name="<%= period[count++] %>"> </td>
		<%}%>
	</tr>
	<%} %>
</tbody></table>
	<input type="submit" value="登録">
	</form>

</body>
</html>