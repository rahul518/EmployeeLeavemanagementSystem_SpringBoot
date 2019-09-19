<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css" />
<title>Login Page</title>
</head>
<body
	background="https://jischoolerp.com/blog/image/29/post-1536646937-image_fileuser_id_2.png">
	<form action="/login" method="post">
		<div class="login" align="center">

			<div class="lgn_left">
				<h1>Login</h1>
				<p>Please enter your Username and password</p>

			</div>

			<div class="lgn_right">

				Username::<input class="field" type="text" placeholder="Username"
					name="Username" required></br> Password::<input class="field"
					type="password" placeholder="Password" name="Password" required>
				</br> <input class="btn" type="submit" value="LOGIN"></br>
			</div>
	</form>
</body>
</html>