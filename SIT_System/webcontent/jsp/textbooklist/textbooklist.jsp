<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import = "java.util.*"%>
    <%@ page import = "java.lang.*"%>
    <%@ page import ="beans.RegisterListModel" %>
    <% 	List<RegisterListModel> register = (List<RegisterListModel>) session.getAttribute("register");
    	String[] str = new String[register.size()];
    	int count = register.size();
    	String save="";
    	for(int i=0;i<count;i++){
    		str[i]=register.get(i).getTextName();
    	}
    %>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>

<!-- 見出し -->
</head>
<body bgcolor="f0f0f0">
<p><%=request.getAttribute("subject")%></p>
<br>



<table><tbody>


	<tr>
		<th class=throriginalclass>教科書</th>
		<th class=throriginalclass>著者名</th>
		<th class=throriginalclass>出版社</th>
		<th class=throriginalclass>キャンパス</th>
	</tr>


	<!-- 教科書列 -->
	<%for(int i=0;i<count; i++){


	if(register.get(i).getTextName().equals(save)){continue;}
	%>
	<tr>
		<td><%=register.get(i).getTextName() %></td>
		<td><%=register.get(i).getAuthor() %></td>
		<td><%=register.get(i).getPublish() %></td>
		<td>
			<select name="textid">
			<%

			for(int j=0;j<str.length;j++){
				if(register.get(i).getTextName().equals(str[j])){
					save=str[j];
			%>
				<option value="${register.get(j).getTextID()}">
					<%=register.get(j).getStudentID()%> <%=register.get(j).getCampus()%>
				</option>
			<%}
			}

			%>
			</select>
		</td>
	</tr>

<%

	} %>


	</tbody></table>
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
