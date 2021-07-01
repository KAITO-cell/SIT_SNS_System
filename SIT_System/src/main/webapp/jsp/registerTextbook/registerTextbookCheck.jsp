<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="beans.RegisterListModel" %>
<% RegisterListModel registerTextbook = (RegisterListModel) session.getAttribute("registerTextbook"); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書登録確認</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<div style="text-align:center;">
<h1>教科書登録</h1>
</div>
<br>
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
                    <td ><%= registerTextbook.getDepartment() %></td>
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
<p>登録する教科書情報はお間違いないですか？</p>
</div>
<form action="/SIT_System/RegisterTextbook" method="get">
<div style="text-align:center;">
<input type="submit" value="送信" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
<input type="hidden" name="act" value="done">
<input type="hidden" name="test1" value="${registerTextbook.getStudentID()}">
<input type="hidden" name="test2" value="${registerTextbook.getStudentName()}">
<input type="hidden" name="test3" value="${registerTextbook.getDepartment()}">
<input type="hidden" name="test4" value="${registerTextbook.getSubject()}">
<input type="hidden" name="test5" value="${registerTextbook.getTextName()}">
<input type="hidden" name="test6" value="${registerTextbook.getAuthor()}">
<input type="hidden" name="test7" value="${registerTextbook.getPublish()}">
<input type="hidden" name="test8" value="${registerTextbook.getCampus()}">
</div>
</form>
<form action="/SIT_System/RegisterTextbook" method="get">
<div style="text-align:center;">
<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
</div>
</form>
</body>
</html>