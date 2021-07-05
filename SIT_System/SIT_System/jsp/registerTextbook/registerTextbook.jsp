<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.RegisterListDAO" %>
<%
	RegisterListDAO rld = new RegisterListDAO();
	List<String> list = rld.selectText();
 %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerTextbook.css">
<meta charset="UTF-8">
<title>教科書登録</title>
</head>
<h2>S.I.T_System</h2>
<body bgcolor="#DCDCDC" text="black">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/departSubject.js"></script>
    <div class="form-wrapper">
    <h1>教科書情報登録</h1>
        <p>登録する情報を入力してください<p>
        <form action="/SIT_System/RegisterTextbook" method="post">
            <table style="margin:0 auto">

                <tr>
                    <td >
                    	<div class="form-item">
							<label class="ef">
                    			<input type=text  name="studentname" required placeholder="ニックネーム">
                    		</label>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<div class="cp_ipselect">
                        <select name="department" id="department" class="cp_sl06" required>
                        	<option value="">学部を選択してください</option>
                            <option value="工学部">工学部</option>
                            <option value="システム理工学部">システム理工学部</option>
                            <option value="デザイン工学部">デザイン工学部</option>
                            <option value="建築学部">建築学部</option>
                        </select>
                        <span class="cp_sl06_highlight"></span>
						<span class="cp_sl06_selectbar"></span>
						<label class="cp_sl06_selectlabel"></label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<div class="cp_ipselect">
                    	<select name="subject" id="subject" class="cp_sl06" required>
                    		<option value="">学科を選択してください</option>
                    	</select>
                    	<span class="cp_sl06_highlight"></span>
						<span class="cp_sl06_selectbar"></span>
						<label class="cp_sl06_selectlabel"></label>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td>
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
                    	<div class="form-item">
							<label class="ef">
                    			<input type=text size="30" name="authorname" required placeholder="著者名">
                    		</label>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td >

                    <div class="form-item">
							<label class="ef">
                    			 <input type=text size="30" name="publishername" required placeholder="出版社名">
                    		</label>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td >
                    	<div class="cp_ipselect" >
                        <select name="campus"  class="cp_sl06" required>
                            <option value="">場所を選択してください</option>
                            <option value="芝浦">芝浦</option>
                            <option value="豊洲">豊洲</option>
                            <option value="大宮">大宮</option>
                        </select>
                        <span class="cp_sl06_highlight"></span>
						<span class="cp_sl06_selectbar"></span>
						<label class="cp_sl06_selectlabel"></label>

                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan=2 style="text-align:center">
                        <div class="button-panel">
                        	<br>
                        	<input type="submit" value="確認" class="button">
                        </div>
                    </td>
                </tr>
        	</table>
        </form>
		<br>
        <form action="/SIT_System/RegisterList" method="get">
				<input type="submit" value="戻る" class="back">
				<input type="hidden" name="action" value="back">
		</form>
    <br>
    </div>
</body>
</html>

