<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,bean.*"%>
<jsp:include page="EmployeeFunctionalities.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeApply</title>
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
</head>
<body background="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxANDg0NEA0PDg0ODQ8PDQ0NDQ8ODQ4PFREWFhgRExMYHSggGB0lGxUVITEhJSkrLi4uFx8zODMsNygtLisBCgoKDQ0OFRAQFS0eHx8tLSstListLS83KysrLSstLSsrLSstLS0rKystLS0tLSstLSstLSsrLS0tKysrLS0rLf/AABEIAKgBLAMBEQACEQEDEQH/xAAaAAEBAQADAQAAAAAAAAAAAAAAAQIDBAUG/8QALBABAQACAQMDAgQHAQAAAAAAAAECEQMEIUExUXEFEiKRsdEyQlJhgaHBgv/EABoBAQEAAwEBAAAAAAAAAAAAAAABAgMEBQb/xAAlEQEAAwEBAAICAQQDAAAAAAAAAQIRAyEEMUGRURJCcdEiYbH/2gAMAwEAAhEDEQA/APWfTvkAAAAAAGc8dxlWclazkuBtbQAAAAAAAHB1WG5vzP0beVsnG3lbJx1HQ6QAAAAAAAAAAAAFwiSkzjYwZoySqqUAV7by3lgAAAAAAOHlmr8t1Z2Gys7DDJkAAAAAAAA6HLh9ts/L4dVZ2NddbbGsMmQAAAAAAAAAAADkk1GLCZFGaMkqqlAFe28t5YAAAAAADOeO4yrOStZyXA3NqAAAAAAAA4epw3N+Z+jZztk428rZOOq6HQAAAAAAAAAAAuE3UlJlupDBFVmjJKqu99O+l58/f+Dj852ev9sZ5cvf5VeXn3Lm7/Jry8+5/h9L0/Q8XHjMZx42e+UmWVvvbXkX79Lzsy8m/fpedmXjO12AAAAAAAAOHlx1flupOw21nYcbNkAAAAAAAA6XLh9ts/L4dNbbDqrOxrDJQAAAAAAAAAHLjNRixmUoiKqSW2SS226kne2kzEeyu57L3fpv0P0z5v8AHF4/9X/jzPkfO/t5/v8A087v83+3n+/9Pdk12naT0k9I815wD516T0QAAAAAAAGc8dxlWclazkuu3twAAAAAAADi6jDc35n6NnOcls52ycdVubwAAAAAAAAGsYkpMt1GDNVXN0nSZ82X24T5yvbHH5rX17U5xtpYdOtecbaX0v0/6bhwTc/Fyec7O/xPaPH7/Jv1n+I/h5Xb5Fuvn1H8O653OAA+dek9EAAAAAAAABwc2Orv3/VvpOxjbSdhxs2QAAAAAAADq8mOrr8m+s7DorOwyyZAAAAAAAANyajFhMlB6P076Rly6yz3hx+P6svj2n93H3+XWnlfZ/8AHL2+VWnlfZfRcPDjx4zHHGY4zxHlXva87adeZa1rTtpbYsQAAHzr0nogAAAAAAAAM547mmVZyVrOS6robxQAAAAAABx82O5v2ZUnJZ0nJcDc2AAAAAAALjEk1y8fHlnZjjLllfSRha0VjZ8hhNorGy976d9Ixw1nyazz9Zj644/vXl9/l2t/xp5Dzu3ypt5XyHquJxgAAAAPnXpPRAAAAAAAAAAdfnx1d+/6t/OdjG6k7DibGYAAAAAAADgzx1W6J1tidhFUAAAAAB2+i6HLl9O2P82d9J/ae7R1715/f209e1aR/wBvoOj6XDhmsZ385X+KvK69LdJ2XmdOluk+uzK041LKmJjSIAAAA+dek9EAAAAAAAAABnkx3LPyZVnJ1azkuo6nQgAAAAAAAM5zcZVnGVZxxs2YAAABoHp9D9L3rLk7Txh5vz7OPt8nPKftydfkZ5T9vZx1JJJqT0k7SOCfftwz77Le2OJiyoxalY4iypiY1KmIqAAD516T0QAAAAAAAAAAHW6jHV37/q6OU7GN3OdjHE242BgGAYBgGAYBgGDiyjOJZxKKAAOTh4cuS/bjN3/U+WN7xWNlja8VjZez0fRY8Xe/iz/q8T4cHXtN/PqHF07Tfz8O5K0Y0rKxxGpUxGpUxMWVjjHFlTEalTEalTExZWKKD516T0QAAAAAAAAAAGeTHcsZVt/TOrWcnXSrsdKbA2BsDYGwNgbA2CZLCwyyZAO10nQ5cne/hw9/N+Gjp2ivkfbT06xXz8vY4eLHCfbjNT9flw2tNp2XHa02nZbRiqC7EWVjiNSphiypiNbTGOLKxTGpUxFlTEa2iY+feg9AAAAAAAAAAAAB1eqw1fu9/X5dPG2xjfztsY4W5sAAAAAAAAZmNt1Ju30kXYiNld8en0n0+TWWfe+MfE+fdydO8z5VzdO2+Vd9zOZQVEAUBEWVMGpUxFlTExqVMTF2xxMalRF2mI8J3O4AAAAAAAAAAABnkx+6WMq2ydWs5OuhZrs7Y9dQAAAAAADl4ODLkup6ebfSML3iv2xteK/b1On6fHjnbvfOV9a5L3m325b3m3252trUAFRAFRAFQNiLtMGpURqVjiLKmJi7TEx4rsdgAAAAAAAAAAAADq9Xhq/d7+vy6eNtjG/lbYx129tAAAAAdzpuiuXfLtPbzf2aL9c8hpv1zyHpYYzGak1J4jmmd+3NMzP2qIqC7ARFABUQBUQBUDYjUqYLKxxMa2mJjx3U6gAAAAAAAAAAAAGeTH7pZ7sq2/pnVrOTrz7NdvZ3ROusAABrj47ldYzdS1orGykzERsvT6boph3v4sv9T4cl+028j6ct+s28h2Wtr0ABUARUF2IIKAiKAgogCoLsRdpiPKb3SAAAAAAAAAAAAAA6vV4fze/a/Lp428xv5W8x1m9uAdnpOjy5e/pj/Vf+e7V07RT/AC09Otaf5evw8GPHNYz5vm/LitebTsuO15tOy3pE1LF1dZsVdRVAAVBRDaCiKgAqIAqAIoCDzG5vAAAAAAAAAAAAAATPH7pZ7sq2/pnVrOTrzrjd/brvvWp7u7YzXXsZr1Oj+l+mXJ/jD9/2cfX5X4p+3H1+T+Kft6X267eHJrk00KzYy1dSxdZamlXWbF1dSxdXUVQFQBFA2gqIoAKiAKiAPNbW8AAAAAAAAAAAAABycXFc7qT5viJa0V+2NrRWPXe4Ojxwv3a3nfXK/wDPZot1taM/Dmv2taM/DmsYRLDUsVdTSrrNiqljLV1NLrLWbFXUsXV1LGWrrOlZaAAqAIqC7ARFABUQB5zY3AAAAAAAAAAAAAO303RXPvl+HH/dar9Yr5H20dO0V8j2Xo4ccxmpNRzTaZnZck2mZ2Sw01LFZazYq6li6upYy1WdKupYusksXV1mxdXUsVdTTJkzYurqaVdAAVAEVBdiCCgCPPZtwAAAAAAAAAADWGNyupN2+ITMR7KTMRGy9LpehmP4su+Xt4n7uTp2mfKuPr3mfKu40uYF1NKus2Lq6li6y1mxVSxdXUsZaus2Lq6li6y1NLqpYurrNjLWWppdXUsXVZsXV1FUBQEFENoKIqDz2baAAAAAAAAAA5un6bLkvbtPOV9GF+kV+2vp1rT7erwcGPHNSd/NvrXHe82+3Dfpa8+uVi1gAAILqaXWWpYurqWKus2KqWMtXWbFZalirqWLq6li6us2MtXUsXWWppVZsXVSxkuoKAqACohsH//Z">
	<marquee direction="left" scrollamount=20 behavior="slide"
		bgcolor="silver">Apply Leave</marquee>
	<center>
		<%
			ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("managers");
		%>
		<form action="/applyLOP" method="post">

			<div class="login" align="center">

				<div class="lgn_left">
					<h1>ApplyLOP</h1>
					<p>Please enter Details</p>

				</div>
				<div class="lgn_right">

					Enter start date:<input class="field" type="date" name="start"
						required></br> Enter End date:<input class="field" type="date"
						name="end" required></br> Enter the Reason:<input class="field"
						name="reason" required></br> Choose CEO to apply to : <select
						name="Manager" required>
						<option value="">Choose</option>
						<%
							for (Employee employee : list) {
						%>
						<option value="<%=employee.getEmployeeName()%>"><%=employee.getEmployeeName()%>(<%=employee.getEmployeeId()%>)
						</option>
						<%
							}
						%>
						</br>
					</select> <input class="button" type="submit" name="submit" value="Submit"></br>
				</div>
		</form>
</body>
</html>