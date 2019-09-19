<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="AdminFunctionalities.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="login.css" />
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
<title>add a user</title>
</head>
<body
	background="https://jischoolerp.com/blog/image/29/post-1536646937-image_fileuser_id_2.png">
	<marquee direction="left" scrollamount=20 behavior="slide"
		bgcolor="silver">Add Employee</marquee>
	<center>
		<form method="post" action="/add">
			<div class="login" align="center">

				Employee Name::<input type="text" name="name" /><br /> Password::<input
					type="text" name="password"><br /> Employee Id::<input
					type="text" name="EmployeeId" /><br /> Address::<input type="text"
					name="address" /><br /> Email::<input type="text" name="Email" /></br/>
				Contact number::<input type="number" name="phonenumber" /><br />
				EmployeeType::<input type="text" name="employeetype" /><br /> <input class="button" type="submit" name="add" value="add" />
		</form>
</body>
</html>
