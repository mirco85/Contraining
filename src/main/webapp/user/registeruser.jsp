<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>

	<div class="loginContainer">
		<form class="register" action="UserServlet?mode=register" method="post">
				<!-- Campo nome -->
				<!-- <label for="firstname">Nome: </label> -->
				<input type="text" id="firstname" name="firstname" placeholder="Nome">
				<!-- Campo cognome -->
				<!-- <label for="lastname">Cognome: </label> -->
				<input type="text" id="lastname" name="lastname" placeholder="Cognome">
				<!-- Campo data di nascita -->
				<!-- <label for="datanascita">Data di nascita: </label> -->
				<input type="date" id="datanascita" name="datanascita" placeholder="Data di nascita">
				<!-- Campo codice fiscale -->
				<!-- <label for="codicefiscale">Codice fiscale: </label> -->
				<input type="text" id="codicefiscale" name="codicefiscale" placeholder="Codice fiscale">
				<!-- Campo username -->
				<!-- <label for="user">Username: </label> -->
				<input type="text" id="user" name="username" placeholder="Username">
				<!-- Campo password -->
				<!-- <label for="pass">Password: </label> -->
				<input type="password" id="pass" name="password" placeholder="Password">
				<!-- Campo conferma password -->
				<!-- <label for="pass">Conferma Password: </label> -->
				<input type="password" id="confermapass" name="confermapassword" placeholder="Conferma password"> 
		
			<button type="submit" value="Login" name="pulsante">Registrati</button>
			
		</form>
		<%
			Object registerValidation = request.getAttribute("registerValid");
			if(registerValidation != null && !((Boolean)registerValidation)) {
				
		%>  
		<p class="loginError">I campi inseriti non sono validi</p>
		<%
			}
		%>
		<% 
		Object passwordnonconforme = request.getAttribute("errorepassword");
		if(passwordnonconforme != null && ((Boolean)passwordnonconforme)) {
			%>
			<p class="loginError">Le password non coincidono</p>
		<% 	
			}

		%>

	</div>
	
</body>
</html>