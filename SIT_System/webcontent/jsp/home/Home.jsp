<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="beans.ScheduleModel"%>
<%@ page import="java.util.List"%>
<%
	List<ScheduleModel> schedule = (List<ScheduleModel>) session.getAttribute("scheduleList");
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
<head>
<meta charset="UTF-8">
<title>ホーム</title>
</head>
<body>
<h2>S.I.T_System</h2>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/departSubject.js"></script>
	<ul class="menu">
    <li class="menu__multi">
        <a href="#" class="init-bottom">学科選択</a>
        <ul class="menu__second-level">
            <li>
                <a href="#" class="init-right">工学部</a>
                <ul class="menu__third-level">
                    <!-- 工学部 -->
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="機械工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[0].submit()">機械工学科</a>
						</form></li>

                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="機械機能工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[1].submit()">機械機能工学科</a>
						</form>
					</li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="材料工学工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[2].submit()">材料工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="応用工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[3].submit()">応用工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="電気工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[4].submit()">電気工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="電子工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[5].submit()">電子工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="情報通信工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[6].submit()">情報通信工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="情報工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[7].submit()">情報工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="土木工学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[8].submit()">土木工学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="工学部">
							<input type="hidden"  name="subject" value="先進国際課程">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[9].submit()">先進国際課程</a>
						</form></li>
                </ul>
            </li>
            <li>
                <a href="#" class="init-right">システム理工学部</a>
                <ul class="menu__third-level">
                    <!-- システム理工学科 -->
                    <li>
                        <form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="国際プログラム">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[10].submit()">国際プログラム</a>
						</form>
                    </li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="電子情報システム学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[11].submit()">電子情報システム学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="機械制御システム学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[12].submit()">機械制御システム学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="環境システム学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[13].submit()">環境システム学科</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="生命科学科-生命科学コース">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[14].submit()">生命科学科-生命科学コース</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="生命科学科-生命医工学コース">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[15].submit()">生命科学科-生命医工学コース</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="システム理工学部">
							<input type="hidden"  name="subject" value="数理科学科">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[16].submit()">数理科学科</a>
						</form></li>
                </ul>
            </li>
            <li>
                <a href="#" class="init-right">デザイン工学部</a>
                <ul class="menu__third-level">
                    <!-- デザイン工学部-->
                    <li>
                        <form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="デザイン工学部">
							<input type="hidden"  name="subject" value="生産・プロダクトデザイン系">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[17].submit()">生産・プロダクトデザイン系</a>
						</form>
                    </li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="デザイン工学部">
							<input type="hidden"  name="subject" value="ロボティクス・情報デザイン系">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[18].submit()">ロボティクス・情報デザイン系</a>
						</form></li>
                </ul>
            </li>
            <li>
                <a href="#" class="init-right">建築学部</a>
                <ul class="menu__third-level">
                    <!-- 建築学部 -->
                    <li>
                        <form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="建築学部">
							<input type="hidden"  name="subject" value="AP:先進的プロジェクトデザインコース">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[19].submit()">AP:先進的プロジェクトデザインコース</a>
						</form>
                    </li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="建築学部">
							<input type="hidden"  name="subject" value="SA:空間・建築デザインコース">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[20].submit()">SA:空間・建築デザインコース</a>
						</form></li>
                    <li><form action="/SIT_System/RegisterList" method="get" name="act">
							<input type="hidden"  name="department" value="建築学部">
							<input type="hidden"  name="subject" value="UA:都市・建築デザインコース">
							<input type="hidden"  name="action" value="home">
								<a href ="javascript:act[21].submit()">UA:都市・建築デザインコース</a>
						</form></li>
                </ul>
            </li>
        </ul>
      </li>
    	<!-- チャット -->
    	<li class="menu__multi">
        	<a href="#" class="init-bottom">チャット</a>
        	<ul class="menu__second-level">
                <li>
					<form action="/SIT_System/Home" method="get" name="act">
						<input type="hidden"  name="act" value="chat">
							<a href ="javascript:act[22].submit()">チャット相手を選択</a>
					</form>
			    </li>
        	</ul>
        </li>
        <!-- 設定 -->
        <li class="menu__multi">
        	<a href="#" class="init-bottom">設定</a>
        	<ul class="menu__second-level">
                <li><form action="/SIT_System/Home" method="post" name="act">
						<input type="hidden"  name="act" value="done">
							<a href ="javascript:act[23].submit()">時間割の変更</a>
					</form></li>
                <li><form action="/SIT_System/Home" method="post" name="act">
						<input type="hidden"  name="act" value="name">
							<a href ="javascript:act[24].submit()">名前の変更</a>
					</form></li>
                <li><form action="/SIT_System/Home" method="post" name="act">
						<input type="hidden"  name="act" value="pass">
							<a href ="javascript:act[25].submit()">パスワードの変更</a>
					</form></li>
        	</ul>
    	</li>
    	<li class="menu__multi">
        	<a href="#" class="init-bottom">その他</a>
        	<ul class="menu__second-level">
            <!-- 第一階層 -->
                <li>
                <form action="/SIT_System/Home" method="post" name="act">
						<input type="hidden"  name="act" value="logout">
							<a href ="javascript:act[26].submit()">ログアウト</a>
					</form>
					</li>
        	</ul>
    	</li>
	</ul>
	<div class="form-wrapper">
	<br>
	<h1>時間割</h1>
	<br>
	<table class="table"><tbody>

	<tr>
		<th class=throriginalclass></th>
		<th class=throriginalclass>月</th>
		<th class=throriginalclass>火</th>
		<th class=throriginalclass>水</th>
		<th class=throriginalclass>木</th>
		<th class=throriginalclass>金</th>
		<th class=throriginalclass>土</th>
	</tr>

 	<tr>
		<td class="tdoriginalclass">1</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFirst().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%=schedule.get(i).getFirst() %></td>
<%			}
		} %>
	</tr>

	<tr>
		<td class="tdoriginalclass">2</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSecond().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%=schedule.get(i).getSecond() %></td>
<%			}
		} %>
	</tr>
 	<tr>
		<td class="tdoriginalclass">3</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getThird().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%=schedule.get(i).getThird() %></td>
		<%}
		} %>
	</tr>
 	<tr>
		<td class="tdoriginalclass">4</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFourth().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%= schedule.get(i).getFourth() %></td>
		<%}
		} %>
	</tr>
 	<tr>
		<td class="tdoriginalclass">5</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getFifth().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%= schedule.get(i).getFifth() %></td>
		<%}
		} %>

	</tr>
	<tr>
		<td class="tdoriginalclass">6</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSixth().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%= schedule.get(i).getSixth() %></td>
		<%}
		} %>
	</tr>
	<tr>
		<td class="tdoriginalclass">7</td>
		<% for(int i =0;i<6;i++){ %>
		<%if(schedule.get(i).getSeventh().equals("0")){ %>
		<td></td>
		<%}else{ %>
		<td><%= schedule.get(i).getSeventh() %></td>
		<%}
		} %>
	</tr>
</tbody>
</table>
<br>
<br>
</div>
</body>
</html>