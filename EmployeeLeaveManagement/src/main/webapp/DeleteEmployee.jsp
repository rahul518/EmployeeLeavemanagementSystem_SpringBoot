<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="AdminFunctionalities.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="login.css" />
<title>DeleteEmployee</title>
</head>
<body
	background="https://jischoolerp.com/blog/image/29/post-1536646937-image_fileuser_id_2.png">
	<marquee direction="left" scrollamount=20 behavior="slide"
		bgcolor="silver">Delete Employee</marquee>
	<center>
		<form method="post" action="/delete">
			<div class="login" align="center">

				<div class="lgn_left">
					<h1>DELETE</h1>
					<p>Please enter Username</p>

				</div>

				<div class="lgn_right">
					Enter the Username to delete:<br> Username::<input
						class="field" type="text" placeholder="name" name="name"></br>
					<br> <br> <input class="btn" type="submit" name="delete"
						value="delete">
				</div>
		</form>
</body>
</html>