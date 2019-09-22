<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">

<title>Login SAMPLE</title>
</head>
<body>

	<div class="centeredContainer">
		<form class="register" action="UserServlet?mode=register" method="post">
				<div class="row">
					<label for="firstname">Nome: </label>
					<div class="inputBox">
						<input type="text" id="firstname" name="firstname" placeholder="Nome">
					</div>
				</div>
				<div class="row">
					<label for="lastname">Cognome: </label>
					<div class="inputBox">
						<input type="text" id="lastname" name="lastname" placeholder="Cognome">
					</div>
				</div>
				<div class="row">
					<label for="datanascita">Data di nascita: </label>
					<div class="inputBox">
						<input type="date" id="datanascita" name="datanascita" placeholder="Data di nascita">
					</div>
				</div>
				<div class="row">
					<label for="codicefiscale">Codice fiscale: </label>
					<div class="inputBox">
						<input type="text" id="codicefiscale" name="codicefiscale" placeholder="Codice fiscale">
					</div>
				</div>
				<div class="row">
					<label for="user">Username: </label>
					<div class="inputBox">
						<input type="text" id="user" name="username" placeholder="Username">
					</div>
				</div>
				<div class="row">
					<label for="pass">Password: </label>
					<div class="inputBox">
						<input type="password" id="pass" name="password" placeholder="Password">
					</div>
				</div>
				<div class="row">
					<label for="pass">Conferma Password: </label>
					<div class="inputBox">
						<input type="password" id="confermapass" name="confermapassword" placeholder="Conferma password"> 
					</div>
				</div>
				<div class="rowButton">
					<button type="submit" value="register" name="pulsante">Registrati</button>
				</div>
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