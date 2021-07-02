<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
    String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
    String usr = "master";
    String pass = "Pracb2021*";
    List<String> list = new ArrayList<String>();
	try {
		// ドライバクラスをロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		// データベースへ接続
		Connection con = DriverManager.getConnection(url,usr,pass);
		Statement stmt = con.createStatement();
		String sql = "SELECT TEXTNAME FROM TEXTLIST;";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
            String tName = rs.getString("TEXTNAME");
           	list.add(tName);
        }
        stmt.close();
        con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書登録</title>
</head>
<body bgcolor="#DCDCDC" text="black">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/departSubject.js"></script>
    <div style="text-align:center">
        <h2 style="text-align:center">教科書情報登録</h2>
        登録する情報を入力してください
        <form action="/SIT_System/RegisterTextbook" method="post">
            <table style="margin:0 auto">
                
                <tr>
                    <td style="width:60">ニックネーム</td>
                    <td ><input type=text size="30" name="studentname"></input></td>
                </tr>
                <tr>
                    <td style="width:60">学部</td>
                    <td>
                        <select name="department" id="department">
                        	<option value="">選択してください</option>
                            <option value="工学部">工学部</option>
                            <option value="システム理工学部">システム理工学部</option>
                            <option value="デザイン工学部">デザイン工学部</option>
                            <option value="建築学部">建築学部</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="width:70">学科</td>
                    <td>
                    	<select name="subject" id="subject">
                    		<option value="">選択してください</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td style="width:70">教科書名</td>
                    <td>
                    	<input type="text" autocomplete="on" name="textname" list="textname">
                    	<datalist id="textname">
                    		
                    			<%for(int i=0; i<list.size(); i++){%>
                    				<option value="<%=list.get(i)%>">
                    			<%}%>
                  			
                    	</datalist>
                    </td>
                </tr>
                <tr>
                    <td style="width:70">著者名</td>
                    <td ><input type=text size="30" name="authorname"></input></td>
                </tr>
                <tr>
                    <td style="width:70">出版社名</td>
                    <td ><input type=text size="30" name="publishername"></input></td>
                </tr>
                <tr>
                    <td style="width:60">場所</td>
                    <td >
                        <select name="campus">
                            <option value="芝浦">芝浦</option>
                            <option value="豊洲">豊洲</option>
                            <option value="大宮">大宮</option>
                        </select>
                        ※手渡したいキャンパスを選択してください
                    </td>
                </tr>
                <tr>
                    <td colspan=2 style="text-align:center">
                        <input type="submit" value="確認" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
                    </td>
                </tr>
        	</table>  
        </form>
        <form action="/SIT_System/RegisterList" method="get">
			<div style="text-align:center;">
				<input type="submit" value="戻る" style="border: 0.3px solid black ; color:white ; background-color: #FF4500">
				<input type="hidden" name="act" value="back"> 
			</div>
		</form>
    </div>
</body>

</html>

