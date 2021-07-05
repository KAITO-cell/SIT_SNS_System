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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/textbook.css">
<!DOCTYPE html>
<html>
<head>
<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>
</head>
<h2>S.I.T_System</h2>
<body>
<!-- 見出し -->
<br>
<div align="center"><h1><%=(String) session.getAttribute("subject")%></h1></div>
<br>

<div class="LIST">自分が登録した教科書リスト</div>
<div align="center">
<table class="table"><tbody>
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
<form method="get" action="/SIT_System/RegisterTextbook">
	<input type="submit" value="教科書登録" class="add">
	</form>
<br>
<br>
<br>
<br>

<div class="LIST">
			登録されている教科書リスト
		</div>
<div align="center">
<table class="table"><tbody>
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
					<div class="cp_ipselect cp_sl03">
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
					</div>
					</form>
			</td>
		</tr>

<%  } %>
</tbody>
</table>
</div>
<form method="post" action="jsp/home/Home.jsp">
<!-- 選択ボタン -->
<br>
<input type="submit" value="戻る" class="back">
</form>
<br>
<br>
</body>
</html>