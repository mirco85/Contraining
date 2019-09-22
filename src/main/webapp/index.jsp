<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/mainstyle.css" rel="stylesheet">


<title>Login SAMPLE</title>
</head>
<body>

	<div class="centeredContainer">
		<div class="logoContainer"></div>
		<div class="loginContainer">
			<form class="login" action="LoginServlet" method="post">
				<div class="row">
					<label for="user">Username: </label>
					<div class="inputBox">
						<input type="text" id="user" name="username" placeholder="Insert username">
					</div>
				</div>
				<div class="row">
					<label for="pass">Password: </label>
					<div class="inputBox">
					 	<input type="password" id="pass" name="password" placeholder="Insert password">
					</div>
				</div>
				<div class="rowButton">
					<button type="submit" value="Login" name="pulsante">Login</button>
				</div>
				<div class="rowButton">
					<a class="registerButton" href="UserServlet?mode=REGISTERUSER">Registrati</a>
				</div>
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
		

		
	</div>
	
</body>
</html>