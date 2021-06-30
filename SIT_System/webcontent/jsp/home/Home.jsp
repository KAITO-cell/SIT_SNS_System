<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="beans.ScheduleModel"%>
<%@ page import="java.util.List"%>


<%
	List<ScheduleModel> schedule = (List<ScheduleModel>) session.getAttribute("scheduleList");
%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ex.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table.tableroriginalclass{
	border-collapse: collapse;}

th.throriginalclass{
	border: 2px solid #999999;
	background-color: #bbddff;
	height:25px;
	width:100px;}

td.tdoriginalclass{
	border: 2px solid #999999;
	background-color: #FFFFFF;
	height:25px;
	width:100px;
	text-align:center;}
	</style>
</head>
<body>

	<input type="button" value="logout">

	<table class="tableroriginalclass"><tbody>

	<tr>
		<th class=throriginalclass></th>
		<th class=throriginalclass>月</th>
		<th class=throriginalclass>火</th>
		<th class=throriginalclass>水</th>
		<th class=throriginalclass>木</th>
		<th class=throriginalclass>金</th>
		<th class=throriginalclass>土</th>
	</tr>

 	<tr>
		<td class=tdoriginalclass>1</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFirst().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%=schedule.get(i).getFirst() %></td>
<%			}
		} %>
	</tr>

	<tr>
		<td class=tdoriginalclass>2</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSecond().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%=schedule.get(i).getSecond() %></td>
<%			}
		} %>
	</tr>
 	<tr>
		<td class=tdoriginalclass>3</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getThird().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%=schedule.get(i).getThird() %></td>
		<%}
		} %>
	</tr>
 	<tr>
		<td class=tdoriginalclass>4</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFourth().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%= schedule.get(i).getFourth() %></td>
		<%}
		} %>
	</tr>
 	<tr>
		<td class=tdoriginalclass>5</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFifth().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%= schedule.get(i).getFifth() %></td>
		<%}
		} %>

	</tr>
	<tr>
		<td class=tdoriginalclass>6</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSixth().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%= schedule.get(i).getSeventh() %></td>
		<%}
		} %>
	</tr>
	<tr>
		<td class=tdoriginalclass>7</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSeventh().equals("0")){ %>
		<td class=tdoriginalclass></td>
		<%}else{ %>
		<td class=tdoriginalclass><%= schedule.get(i).getSeventh() %></td>
		<%}
		} %>
	</tr>
</tbody>
</table>
	<form method="get" action="/SIT_System/Registerlist">
		<br>

		<!-- プルダウン -->
		<select name="subject">
      		<option value="情報工学科">情報工学科</option>
      		<option value="情報通信工学科">情報通信工学科</option>
      	</select>

		<!-- 選択ボタン -->
		<input type="submit" value="学科選択">
		<input type="hidden"  name="action" value="home">
	</form>
	<form method="post" action="/SIT_System/Home">
		<br>

		<!-- プルダウン -->
		<select name="act">
      	<option value="done">時間割</option>
      	<option value="name">名前の変更</option>
      	<option value="pass">パスワードの変更</option>
		</select>

		<!-- 選択ボタン -->
		<input type="submit" value="設定">
		<!-- <input type="hidden"  name="act" value="done">  -->
	</form>

</body>
</html>
