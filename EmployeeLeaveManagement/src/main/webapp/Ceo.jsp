<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CEOFunctionalities</title>
<style>
.button {
	background-color: #29363f;
	font-weight: bold;
	margin: 10px 25px;
	width: 100px;
	border: 1px #525d65 solid;
	padding: 10px;
	color: #CCC;
}
</style>
</head>
<marquee direction="left" scrollamount=20 behavior="slide"
	bgcolor="silver">WELCOME CEO</marquee>
<body bgcolor="#afafaf">
	<div align="right">
		<form method="post" action="Login.jsp">
			<input class="button" type="submit" name="Logout" value="Logout">
		</form>
	</div>

	<div align="left">
		<form method="post" action="Ceo.jsp">
			<input class="button" type="submit" name="back to home" value="Back To Home">
		</form>
	</div>
	<center>

		<h3 id="an">
			<a href="/AcceptReject">Accept or Reject</a>
		</h3>
</body>
</html>