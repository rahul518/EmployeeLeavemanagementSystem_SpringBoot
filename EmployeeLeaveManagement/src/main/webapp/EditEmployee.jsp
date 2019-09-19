<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="AdminFunctionalities.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditEmployee</title>
</head>
<body
	background="https://jischoolerp.com/blog/image/29/post-1536646937-image_fileuser_id_2.png">
	<marquee direction="left" scrollamount=20 behavior="slide"
		bgcolor="silver">Edit Employee</marquee>
	<form action="/edit" method="post">
		Enter Employee Name:::<input type="text" name="employeeName" /> Edit
		Address::<input type="text" name="address" /> Edit PhoneNumber::<input
			type="text" name="contact" /> Edit E-mail::<input type="text"
			name="email" /> <input type="submit" name="EditEmployee" value="edit" />
	</form>
</body>
</html>