<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import = "java.util.*"%>
    <%@ page import = "java.lang.*"%>
    <%@ page import = "javax.servlet.http.*"%>
    <%@ page import ="beans.RegisterListModel" %>
    <% 	List<RegisterListModel> register = (List<RegisterListModel>) session.getAttribute("register");
    	String[] str = new String[register.size()];
    	int count = register.size();
    	ArrayList<String> save_list = new ArrayList<>();
    	for(int i=0;i<count;i++){
    		str[i]=register.get(i).getTextName();
    	}
    %>
    <% 	List<RegisterListModel> mytextlist = (List<RegisterListModel>) session.getAttribute("mytextlist");
    	String[] mylist = new String[mytextlist.size()];
    	int mylistcount = mytextlist.size();
    	ArrayList<String> save_mytextlist = new ArrayList<>();
    %>
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>
</head>
<body>
<!-- 見出し -->
<div align="center"><h1><%=(String) session.getAttribute("subject")%></h1></div>
<br>


<div align="center">
<table><tbody>

	<form method="get" action="/SIT_System/RegisterTextbook">
		<tr>
			<div align="center">
				<h1>自分が登録した教科書リスト</h1>
			</div>
			<div align="right">
				<input type="submit" value="教科書を登録">
			</div>
		</tr>
	</form>
	<tr>
		<th class=throriginalclass>教科書</th>
		<th class=throriginalclass>著者名</th>
		<th class=throriginalclass>出版社</th>
		<th class=throriginalclass>キャンパス</th>
	</tr>


	<!-- 教科書列 -->
	<%for(int i=0;i<mylistcount; i++){ %>
	<tr>
	    <!-- 教科書情報を表示 -->
		<td><%=mytextlist.get(i).getTextName() %></td>
		<td><%=mytextlist.get(i).getAuthor() %></td>
		<td><%=mytextlist.get(i).getPublish() %></td>
		<td><%=mytextlist.get(i).getCampus() %></td>
	</tr>

<% } %>
</tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<div align="center">
<table><tbody>

	<tr>
		<div align="center">
			<h1><p>登録されている教科書リスト</p></h1>
		</div>
	</tr>
	<tr>
		<th class=throriginalclass>教科書</th>
		<th class=throriginalclass>著者名</th>
		<th class=throriginalclass>出版社</th>
		<th class=throriginalclass>学籍番号/キャンパス</th>
	</tr>


	<!-- 教科書列 -->
	<%for(int i=0;i<count; i++){

		//教科書の重複チェック
		boolean hit = false;
		for(int s=0;s<save_list.size();s++){
	       if(register.get(i).getTextName().equals(save_list.get(s))){hit=true;}
	    }
	    if(hit==true){continue;}
	    %>
	<tr>
	    <!-- 教科書情報を表示 -->
			<td><%=register.get(i).getTextName() %></td>
			<td><%=register.get(i).getAuthor() %></td>
			<td><%=register.get(i).getPublish() %></td>
			<td>

		    	<form method="post" action="/SIT_System/Request">
					<select name="textid" onchange="submit(this.form)">
			    		<option value="-1"selected>選択してください</option>
					<%
					//教科書を出してる生徒の学籍番号を表示
					for(int j=0;j<str.length;j++){
						if(register.get(i).getTextName().equals(str[j])){
					%>
							<option value="<%=register.get(j).getTextID()%>">
								<%=register.get(j).getStudentID()%> <%=register.get(j).getCampus()%>
							</option>
					<%
			  			}
					}

					//一度検索した教科書を保存
					save_list.add(register.get(i).getTextName());
					%>
					</select>
				</form>
			</td>
		</tr>

<%  } %>
</tbody>
</table>
</div>
<form method="post" action="jsp/home/Home.jsp">
<!-- 選択ボタン -->
<input type="submit" value="戻る">
</form>

</body>
</html>