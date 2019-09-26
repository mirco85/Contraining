<%@ page language="Java" pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.model.User.Usertype" %>
<!DDOCTYPE html>
<html>
	<head></head>
	<body>
		<% 	UserDTO loggedUser = (UserDTO)session.getAttribute("user"); 
			if(loggedUser == null)
				response.sendRedirect("/index.jsp");
			else {
				if(loggedUser.getUsertype() == Usertype.ADMIN) {
					%>
					<div class="navbar">
						<a href="/homeadmin.jsp">Home</a>
						<a class="active" href="/user/getall">Users</a>
						<a href="/category/getall">Categories</a>
						<a href="/test/getall">Tests</a>
						<a href="/Questions/getall">Questions</a>
						<a href="/questionanswers/getall">Question answers</a>
						<a href="/useranswers/getall">User answers</a>
						<a href="/user/logout" id="logout">Logout</a>
					</div>
					<%
				} else {
					%>
					<div class="navbar">
						<a href="/homeuser.jsp">Home</a>					
						<a href="/user/logout" id="logout">Logout</a>
					</div>
					<%
				}
			}
		%>
		
	</body>
</html>