<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting</title>
</head>
<body>

	<form action="/sit_sns_system/Home" method="post">
	<select name="state">
		<option value="mon">月</option>
		<option value="tue">火</option>
		<option value="wed">水</option>
		<option value="thu">木</option>
		<option value="fri">金</option>
		<option value="sat">土</option>
	</select>
	<table>
	<tbody>
		<tr>
			<td><input type="text" name="fir" value="">1</td>
			<td><input type="text" name="sec" value="">2</td>
			<td><input type="text" name="thr" value="">3</td>
			<td><input type="text" name="fou" value="">4</td>
			<td><input type="text" name="fif" value="">5</td>
			<td><input type="text" name="six" value="">6</td>
			<td><input type="text" name="sev" value="">7</td>
		</tr>



	</tbody></table>
	<input type="submit" value="登録">
	<input type="hidden"  name="act" value="home">
	</form>

</body>
</html>