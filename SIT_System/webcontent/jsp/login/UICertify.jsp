<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>S.I.T SNS System</title>
	</head>
	<body bgcolor="f0f0f0">
		<br>
		<h1><p style="text-align:center">ログイン</p></h1>
		<br>
		<br>
		<form action="/S.I.T_SNS_system/SIT_SNS_system_login" method ="post">

			<p style="text-align:center">学籍番号:   <input type="text" name="id"></p><br>
			<p style="text-align:center">パスワード: <input type="password" name="pass"></p><br>
			<br>
			<p style="text-align:center"><input type="checkbox" id="01-A" name="checkbox01" checked="checked">ログインしたままにする</p> 
			<br>
			<br>
			<p style="text-align:center"><input type="submit" value="ログイン" class="button"></p>
		</form>
		<br>
		<br>
		<br>
		<p style="text-align:center"><input type="button" onclick="location.href='./registerAccount.jsp'" value="新規登録はこちら" class="button2"></p>
	</body>
</html>

<style type="text/css">
.button {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 21pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 22px 27px;   /* 余白       */
  background    : #ff0000;     /* 背景色     */
  color         : #ffffff;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  opacity       : 1;           /* 透明度     */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 6px 6px 3px #666666;  /* 影の設定 */
}
.button:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  opacity       : 0.8;         /* カーソル時透明度 */
}
.button2 {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 20pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 18px 37px;   /* 余白       */
  background    : #ffffff;     /* 背景色     */
  color         : #000000;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  opacity       : 1;           /* 透明度     */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 6px 6px 3px #666666;  /* 影の設定 */
}
.button2:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  opacity       : 0.8;         /* カーソル時透明度 */
}

h1{
	padding: 1rem 3rem;
	background: #33FF33;
}


</style>