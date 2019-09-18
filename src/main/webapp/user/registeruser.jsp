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
				<label for="firstname">Nome: </label>
				<input type="text" id="firstname" name="firstname" placeholder="Insert firstname">
				<!-- Campo cognome -->
				<label for="lastname">Cognome: </label>
				<input type="text" id="lastname" name="lastname" placeholder="Insert lastname">
				<!-- Campo data di nascita -->
				<label for="datanascita">Data di nascita: </label>
				<input type="date" id="datanascita" name="datanascita" placeholder="Insert datanascita">
				<!-- Campo codice fiscale -->
				<label for="codicefiscale">Codice fiscale: </label>
				<input type="text" id="codicefiscale" name="codicefiscale" placeholder="Insert codicefiscale">
				<!-- Campo username -->
				<label for="user">Username: </label>
				<input type="text" id="user" name="username" placeholder="Insert username">
				<!-- Campo password -->
				<label for="pass">Password: </label>
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
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
	</div>
	
</body>
</html>