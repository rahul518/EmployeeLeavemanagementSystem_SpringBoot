<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,bean.* "%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CANCEL REQUEST</title>
</head>
<marquee direction="left" scrollamount=20 behavior="slide"
	bgcolor="silver">Cancel Leave</marquee>
<body bgcolor="#33FFD5">
	<center>
		<h1>CANCEL REQUEST</h1>
		<%
			ArrayList<LeaveDetails> leavedetails = (ArrayList<LeaveDetails>) request.getAttribute("leaves");
		%>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>LEAVEID</th>
					<th>START DATE</th>
					<th>END DATE</th>
					<th>REASON</th>
					<th>STATUS</th>
					<th>DAYSLEFT</th>
					<th>APPLYTO</th>
				</tr>
			</thead>
			<tr>
				<%
					for (LeaveDetails leavedetail : leavedetails) {
						out.print("<tr><td>" + leavedetail.getLeaveid() + "</td>" + "<td>" + leavedetail.getStart() + "</td>"
								+ "<td>" + leavedetail.getEnd() + "</td>" + "<td>" + leavedetail.getReason() + "</td>" + "<td>"
								+ leavedetail.getStatus() + "</td>" + "<td>" + leavedetail.getDays_left() + "</td>" + "<td>"
								+ leavedetail.getApplyTo() + "</td>");

					}
				%>
			</tr>
		</table>
		<br> <br>

		<form method="post" action="/cancelleave">
			Enter the ID to Cancel:<br> <input type="text" name="leaveid"><br>
			<input type="submit" value="cancel">
		</form>
</body>
</html>