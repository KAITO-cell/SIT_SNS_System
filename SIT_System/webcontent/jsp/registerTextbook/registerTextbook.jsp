<!----------------------------------------------------------------------------------------------------
---File Name	: registerTextbook.jsp
---Version		: V2.0
---Designer		: 福田 怜哉
---Purpose		: 教科書登録画面
---
------------------------------------------------------------------------------------------------------>
<!--
---Revision :
---V1.0 : 福田 怜哉	2021.06.29
---V1.1 : 福田 怜哉	2021.07.01
---V1.2 : 福田 怜哉	2021.07.02
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 必要なパッケージをインポート -->
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.RegisterListDAO" %>
<%
	RegisterListDAO rld = new RegisterListDAO();
	List<String> list = rld.selectText();
 %>

<!-- ログイン中の生徒の情報 -->
<%
	String stdid = (String) session.getAttribute("loginStudent");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerTextbook.css">

<!-- タイトル -->
<meta charset="UTF-8">
<title>教科書登録</title>
</head>

<!-- 見出し -->
<h2>S.I.T_System&nbsp;<span><%= stdid%>さん</span></h2>

<body bgcolor="#DCDCDC" text="black">
	<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/departSubject.js"></script>
	<div class="form-wrapper">
		<h1>教科書情報登録</h1>
	    <p>登録する情報を入力してください<p>

	    <!-- 入力された情報をpostする -->
	    <form action="/SIT_System/RegisterTextbook" method="post">
	    	<table style="margin:0 auto">
	        	<tr>
	            	<td>

	                	<!-- ニックネームを入力 -->
	                	<div class="form-item">
							<label class="ef">
	                    		<input type=text  name="studentname" required placeholder="ニックネーム">
	                    	</label>
	                    </div>

	                </td>
	             </tr>
	             <tr>
	                <td>

	                	<!-- 学部を選択 -->
	                	<div class="cp_ipselect">
	                    	<select name="department" id="department" class="cp_sl06" required>
	                        	<option value="">学部を選択してください</option>
	                            <option value="工学部">工学部</option>
	                            <option value="システム理工学部">システム理工学部</option>
	                            <option value="デザイン工学部">デザイン工学部</option>
	                            <option value="建築学部">建築学部</option>
	                        </select>

	                        <!-- selectの装飾 -->
	                        <span class="cp_sl06_highlight"></span>
							<span class="cp_sl06_selectbar"></span>
							<label class="cp_sl06_selectlabel"></label>

	                     </div>
	             	</td>
	       		  </tr>
	              	<tr>
	                	<td>

	                    	<!-- 学科を選択 -->
	                    	<div class="cp_ipselect">
	                    		<select name="subject" id="subject" class="cp_sl06" required>
	                    			<option value="">学科を選択してください</option>
	                    		</select>

	                    	<!-- selectの装飾 -->
	                    	<span class="cp_sl06_highlight"></span>
							<span class="cp_sl06_selectbar"></span>
							<label class="cp_sl06_selectlabel"></label>

	                    	</div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>

	                    	<!-- 教科書名を入力 -->
	                    	<div class="form-item">
								<label class="ef">
	                    			<input type="text" autocomplete="on" name="textname" list="textname" required placeholder="教科書名">
	                    		</label>
	                    	</div>

	                    	<datalist id="textname">
	                    			<%for(int i=0; i<list.size(); i++){%>
	                    				<option value="<%=list.get(i)%>">
	                    			<%}%>
	                    	</datalist>

	                    </td>
	                </tr>
	                <tr>
	                    <td >

							<!-- 著者名を入力 -->
	                    	<div class="form-item">
								<label class="ef">
	                    			<input type=text size="30" name="authorname" required placeholder="著者名">
	                    		</label>
	                    	</div>

	                    </td>
	                </tr>
	                <tr>
	                    <td >

	                    <!-- 出版社を入力 -->
	                    <div class="form-item">
								<label class="ef">
	                    			 <input type=text size="30" name="publishername" required placeholder="出版社名">
	                    		</label>
	                    </div>

	                    </td>
	                </tr>
	                <tr>
	                    <td >

	                    	<!-- 取引をする場所を選択 -->
	                    	<div class="cp_ipselect" >
	                       		<select name="campus"  class="cp_sl06" required>
	                            	<option value="">場所を選択してください</option>
	                            	<option value="芝浦">芝浦</option>
	                            	<option value="豊洲">豊洲</option>
	                            	<option value="大宮">大宮</option>
	                        	</select>

	                        <!-- selectを修飾 -->
	                        <span class="cp_sl06_highlight"></span>
							<span class="cp_sl06_selectbar"></span>
							<label class="cp_sl06_selectlabel"></label>

	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan=2 style="text-align:center">

	                        <!-- 確認ボタン -->
	                        <div class="button-panel">
	                        	<br>
	                        	<input type="submit" value="確認" class="button">
	                        </div>

	                    </td>
	                </tr>
	        	</table>
	        </form>
			<br>

	        <!-- 戻るボタン -->
	        <form action="/SIT_System/RegisterList" method="get">
					<input type="submit" value="戻る" class="back">
					<input type="hidden" name="action" value="back">
			</form>

	    <br>
	</div>
</body>
</html>

