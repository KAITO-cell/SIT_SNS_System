<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.RegisterListModel" %>
<% RegisterListModel registerTextbook = (RegisterListModel) session.getAttribute("registerTextbook"); %>
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerTextbook.css">
<meta charset="UTF-8">
<title>教科書登録確認</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<h2>S.I.T_System&nbsp;<span><%= stdid%></span>さん</h2>
<div class="form-wrapper">
<h1>教科書登録</h1>
<br>
<div style="text-align:center;">
<table style="margin:0 auto">
                <tr>
                    <td style="width:60">学籍番号</td>
                    <td ><%= registerTextbook.getStudentID() %></td>
                </tr>
                <tr>
                    <td style="width:60">名前</td>
                    <td ><%= registerTextbook.getStudentName() %></td>
                </tr>
                <tr>
                    <td style="width:60">学部</td>
                    <td ><%= registerTextbook.getDepartMent() %></td>
                </tr>
                <tr>
                    <td style="width:70">学科</td>
                    <td ><%= registerTextbook.getSubject() %></td>
                </tr>
                <tr>
                    <td style="width:70">教科書名</td>
                    <td ><%= registerTextbook.getTextName() %></td>
                </tr>
                <tr>
                    <td style="width:70">著者名</td>
                    <td ><%= registerTextbook.getAuthor() %></td>
                </tr>
                <tr>
                    <td style="width:70">出版社名</td>
                    <td ><%= registerTextbook.getPublish() %></td>
                </tr>
                <tr>
                    <td style="width:60">場所</td>
                    <td ><%= registerTextbook.getCampus() %></td>
                </tr>
</table>
<br>
<p>登録する教科書情報はお間違いないですか？</p>
<br>
</div>
<form action="/SIT_System/RegisterTextbook" method="get">
<div class="button-panel">
<input type="submit" value="送信" class="button">
<input type="hidden" name="act" value="done">
<input type="hidden" name="test1" value="${registerTextbook.getStudentID()}">
<input type="hidden" name="test2" value="${registerTextbook.getStudentName()}">
<input type="hidden" name="test3" value="${registerTextbook.getDepartMent()}">
<input type="hidden" name="test4" value="${registerTextbook.getSubject()}">
<input type="hidden" name="test5" value="${registerTextbook.getTextName()}">
<input type="hidden" name="test6" value="${registerTextbook.getAuthor()}">
<input type="hidden" name="test7" value="${registerTextbook.getPublish()}">
<input type="hidden" name="test8" value="${registerTextbook.getCampus()}">
</div>
</form>
<br>
<form action="/SIT_System/RegisterTextbook" method="get">
<div style="text-align:center;">
<input type="submit" value="戻る" class="back">
</div>
</form>
<br>
</div>
</body>
</html>