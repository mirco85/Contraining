<%@ page language="java"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	</head>
	<body>
		<%
			UserDTO user = (UserDTO)session.getAttribute("user");
			if(user != null) {
				if(user.getUsertype().toUpperCase().equals("ADMIN")) {
					// MENU ADMIN
					%>
					<div class="navbar">
					  <a class="active" href="homeadmin.jsp">Home</a>
					  <a href="UserServlet?mode=userlist">Users</a>
					  <a href="AnswerServlet?mode=answerlist">Answers</a>
					  <a href="LogoutServlet" id="logout">Logout</a>
					</div>
					<%
				} else {
					// MENU USER
					%>
					<div class="navbar">
					  	<a class="active" href="homeuser.jsp">Home</a>
						<a href="LogoutServlet" id="logout">Logout</a>
					</div>
					<%
				}
			}
		%>
	</body>
</html>