<!----------------------------------------------------------------------------------------------------
---File Name	        : textbooklist.jsp
---Version		: V1.3
---Designer		: 奈良 操樹
---Date                 : 2021.07.04
---Purpose		: 教科書リスト画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 奈良 操樹	2021.06.29
---V1.1 : 奈良 操樹	2021.07.01
---V1.2 : 奈良 操樹	2021.07.03
---V1.3 : 奈良 操樹	2021.07.04
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 必要なパッケージをインポート -->
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

    <!-- 登録した教科書リスト情報 -->
    <% 	List<RegisterListModel> mytextlist = (List<RegisterListModel>) session.getAttribute("mytextlist");
    	String[] mylist = new String[mytextlist.size()];
    	int mylistcount = mytextlist.size();
    	ArrayList<String> save_mytextlist = new ArrayList<>();
    %>

	<!-- ログイン中の生徒の情報 -->
   <%
	String stdid = (String) session.getAttribute("loginStudent");
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/textbook.css">

<!-- タイトル -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教科書リスト</title>
</head>

<body>
	<!-- 見出し -->
	<h2>S.I.T SNS System&nbsp;<span><%= stdid%>さん</span></h2>
	<br>

	<!-- 学科名を表示 -->
	<div align="center"><h1><%=(String) session.getAttribute("subject")%></h1></div>
	<br>

	<!-- 自分が登録した教科書を表示 -->
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

	<!-- 教科書登録画面への遷移ボタン -->
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

	<!-- 登録されている教科書を表示 -->
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

	<!-- 戻るボタン -->
	<form method="post" action="jsp/home/Home.jsp">
		<br>
		<input type="submit" value="戻る" class="back">
	</form>

	<br>
	<br>
</body>
</html>
