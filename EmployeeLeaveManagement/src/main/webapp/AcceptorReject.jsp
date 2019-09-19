<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCEPT OR REJECT</title>
<marquee direction="left" scrollamount=20 behavior="slide"
	bgcolor="silver">Accept Or Reject</marquee>
</head>
<body background="https://i.stack.imgur.com/xfn1X.jpg">
	<h1>ACCEPT OR REJECT</h1>
	<%
		ArrayList<LeaveDetails> leavedetails = (ArrayList<LeaveDetails>) request.getAttribute("list");
	%>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>LEAVEID</th>
				<th>START DATE</th>
				<th>END DATE</th>
				<th>EMPLOYEENAME</th>
				<th>APPLYTO</th>
				<th>STATUS</th>
				<th>REASON</th>
			</tr>
		</thead>
		<tr>
			<%
				for (LeaveDetails leavedetail : leavedetails) {
					out.print("<tr><td>" + leavedetail.getLeaveid() + "</td>" + "<td>" + leavedetail.getStart() + "</td>"
							+ "<td>" + leavedetail.getEnd() + "</td>" + "<td>" + leavedetail.getEmployeename() + "</td>"
							+ "<td>" + leavedetail.getApplyTo() + "</td>" + "<td>"
							+ leavedetail.getStatus() + "</td>" + "<td>" + leavedetail.getReason() + "</td>");
				}
			%>
		</tr>
	</table>
	<br>
	<br>
	<form method="post" action="/acceptrequest">
		Enter the LEAVEID to Accept: <input type="text" name="leaveid">
		<input type="submit" value="accept">
	</form>

	<form method="post" action="/rejectrequest">
		Enter the LEAVEID to Reject: <input type="text" name="leaveid">
		<input type="submit" value="reject">
	</form>
</body>
</html>