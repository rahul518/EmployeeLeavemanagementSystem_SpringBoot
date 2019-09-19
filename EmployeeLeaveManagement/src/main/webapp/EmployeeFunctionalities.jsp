<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Functionalities</title>
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
	bgcolor="silver">WELCOME EMPLOYEE</marquee>
<body bgcolor="#33FFD5">
	<div align="right">
		<form method="post" action="Login.jsp">
			<input class="button" type="submit" name="Logout" value="Logout">
		</form>
	</div>

	<div align="left">
		<form method="post" action="EmployeeFunctionalities.jsp">
			<input class="button" type="submit" name="Back to home"
				value="Back To Home">
		</form>
	</div>
	<center>
		<h3 id="an">
			<a href="/getManagers">Apply for leave</a>
		</h3>
		<h3 id="an">
			<a href="/getManagersforLOP">Apply for LOP</a>
		</h3>
		<h3 id="an">
			<a href="/cancelview">Cancel leave</a>
		</h3>
		<h3 id="an">
			<a href="/cancellopview">cancel LOP</a>
		</h3>
</body>
</html>
