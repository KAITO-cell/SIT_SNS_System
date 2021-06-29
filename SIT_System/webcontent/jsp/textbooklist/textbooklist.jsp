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
<!DOCTYPE html>
<html>
<head>

<!-- タイトル -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>

<!-- 見出し -->
</head>
<body bgcolor="f0f0f0">
<p><%=(String) session.getAttribute("subject")%></p>
<br>


<form method="post" action="/SIT_System/Request">
<table><tbody>


	<tr>
		<th class=throriginalclass>教科書</th>
		<th class=throriginalclass>著者名</th>
		<th class=throriginalclass>出版社</th>
		<th class=throriginalclass>学籍番号/キャンパス</th>
	</tr>


	<!-- 教科書列 -->
	<%for(int i=0;i<count; i++){

		boolean hit = false;      //教科書の重複チェック
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
			<select name="textid">
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
		    //System.out.println(save_list);
			%>
			</select>
		</td>
	</tr>

<%

	} %>
</tbody>
</table>
<!-- 選択ボタン -->
<input type="submit" value="選択">
</form>

<form method="post" action="jsp/home/Home.jsp">
<!-- 選択ボタン -->
<input type="submit" value="戻る">
</form>
</body>
</html>
