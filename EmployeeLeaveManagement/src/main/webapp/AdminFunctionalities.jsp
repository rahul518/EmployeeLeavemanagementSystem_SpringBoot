<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminFunctionalities</title>
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

<div align="right">
	<form method="post" action="Login.jsp">
		<input class="button" type="submit" name="Logout" value="Logout">
	</form>
</div>

<div align="left">
	<form method="post" action="AdminFunctionalities.jsp">
		<input class="button" type="submit" name="back to home" value="Back To Home">
	</form>
</div>
</head>
<marquee direction="left" scrollamount=20 behavior="slide"
	bgcolor="silver">WELCOME ADMIN</marquee>

<body
	background="https://jischoolerp.com/blog/image/29/post-1536646937-image_fileuser_id_2.png">

	<h3 id="an">
		<a href="AddEmployee.jsp">Add employee</a>
	</h3>
	<h3 id="an">
		<a href="DeleteEmployee.jsp">Delete employee</a>
	</h3>
	<h3 id="an">
		<a href="EditEmployee.jsp"> Edit employees</a>
	</h3>
	
</body>
</html>