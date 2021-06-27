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
<p><%=request.getAttribute("subject")%></p>
<br>

<%int count = (int)((request.getAttribute("count")));%>
<%ArrayList<String> studentid = (ArrayList) request.getAttribute("s_id_list");%>
<%                                        //学籍番号
ArrayList<String> studentname = (ArrayList) request.getAttribute("s_name_list");                                       //学生の名前
ArrayList<String> textid = (ArrayList) request.getAttribute("t_id_list");                                              //教科書ID
ArrayList<String> textname = (ArrayList) request.getAttribute("t_name_list");                                         //教科書名
ArrayList<String> author = (ArrayList) request.getAttribute("author_list");                                           //著者
ArrayList<String> publish = (ArrayList) request.getAttribute("pub_list");                                         //出版社
ArrayList<String> campus = (ArrayList) request.getAttribute("cam_list");
%>
<%for(int i=0; i<count; i++){ %>
<form method="post" action="/SIT_SNS_System/Request">
<button type="submit" name="textid" value="<%=textid.get(i)%>"><%=studentid.get(i)%>&emsp;<%=textname.get(i)%>&emsp;<%=author.get(i)%>&emsp;<%=publish.get(i)%>&emsp;<%=campus.get(i)%></button>
<br>
</form>
<% } %>


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
