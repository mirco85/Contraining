<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>

	<div class="loginContainer">
		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username">
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
			<a href="UserServlet?mode=REGISTERUSER">Registrati</a>
			<!--<a href="/user/registeruser.jsp">Registrati</a>-->
		</form>

		<%
			Object loginError = request.getAttribute("credentialsError");
			if(loginError != null && ((Boolean)loginError))	{
				%>
				<p class="loginError">Username o password errati.</p>
				<%
			}
		%>
	</div>
	
</body>
</html>