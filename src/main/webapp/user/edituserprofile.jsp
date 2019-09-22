<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"     import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Account</title>
<link href="css/mainstyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<% UserDTO loggeduser = (UserDTO) session.getAttribute("user"); %>
	<div class="main mainContainer">
		<%
			Object passworderrata = request.getAttribute("errorepassword");
			if(passworderrata != null && ((Boolean)passworderrata))	{
				%>
				<p class="passwordErrata">Le Password non coincidono.</p>
				<%
			}
		%>
		<form action="UserServlet?mode=updateuserprofile" method="post">
			<div class="row">
			    
			      	<label for="username">UserName</label>
			    
			    <div class="inputBox">
			      	<input type="text" id="username" name="username" value = "<%=loggeduser.getUsername()%>" >
			    </div>
		  	</div>
		  	
		  	<div class="row">
		  		
		      		<label for="password">Password</label>
		    	
		   		<div class="inputBox">
		 			<input type="password" id="password" name="password"/>
		 			
		    	</div>
		  	</div>
		  	
		  	
		  	<div class="row">
		  		
		      		<label for="confermapassword">Conferma Password</label>
		    	
		   		<div class="inputBox">
		 			<input type="password" id="confermapassword" name="confermapassword"/>
		 			
		    	</div>
		  	</div>
		  	<div class="row">
		  		
		      		<label for="firstname">Firstname</label>
		    	
		   		<div class="inputBox">
		 			<input type="text" id="firstname" name="firstname"value="<%=loggeduser.getFirstname() %>" />
		    	</div>
		  	</div>
		  	<div class="row">
		  		
		      		<label for="lastname">Lastname</label>
		    	
		   		<div class="inputBox">
		 			<input type="text" id="lastname" name="lastname" value="<%=loggeduser.getLastname() %>" />
		    	</div>
		  	</div>
		  	<div class="row">
		  		
		      		<label for="datanascita">Data di nascita</label>
		    	
		   		<div class="inputBox">
		 			<input type="date" id="datanascita" name="datanascita"  value ="<%=loggeduser.getDatanascita() %>" />
		    	</div>
		  	</div>
		  	<div class="row">
		  		
		      		<label for="codicefiscale">Codice fiscale</label>
		    	
		   		<div class="inputBox">
		 			<input type="text" id="codicefiscale" name="codicefiscale" value ="<%=loggeduser.getCodicefiscale() %>" />
		    	</div>
		  	</div>
		  	<div class="rowButton">
		    	<button type="submit" >Aggiorna</button>
		  	</div>
		</form>
	</div>



</body>
</html>