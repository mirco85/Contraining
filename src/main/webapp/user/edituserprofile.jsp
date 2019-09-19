<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"     import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Account</title>
</head>
<body>
<% UserDTO loggeduser = (UserDTO) session.getAttribute("user"); %>
<form id="floatright" action="UserServlet?mode=updateuserprofile" method="post">
	<div class="row">
	    <div class="col-25">
	      	<label for="username">UserName</label>
	    </div>
	    <div class="col-75">
	      	<input type="text" id="username" name="username" value = "<%=loggeduser.getUsername()%>" >
	    </div>
  	</div>
  	
  	<div class="row">
  		<div class="col-25">
      		<label for="password">Password</label>
    	</div>
   		<div class="col-75">
 			<input type="password" id="password" name="password"/>
 			
    	</div>
  	</div>
  	
  	
  	<div class="row">
  		<div class="col-25">
      		<label for="confermapassword">Conferma Password</label>
    	</div>
   		<div class="col-75">
 			<input type="password" id="confermapassword" name="confermapassword"/>
 			
    	</div>
  	</div>
  	<div class="row">
  		<div class="col-25">
      		<label for="firstname">Firstname</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="firstname" name="firstname"value="<%=loggeduser.getFirstname() %>" />
    	</div>
  	</div>
  	<div class="row">
  		<div class="col-25">
      		<label for="lastname">Lastname</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="lastname" name="lastname" value="<%=loggeduser.getLastname() %>" />
    	</div>
  	</div>
  	<div class="row">
  		<div class="col-25">
      		<label for="datanascita">Data di nascita</label>
    	</div>
   		<div class="col-75">
 			<input type="date" id="datanascita" name="datanascita"  value ="<%=loggeduser.getDatanascita() %>" />
    	</div>
  	</div>
  	<div class="row">
  		<div class="col-25">
      		<label for="codicefiscale">Codice fiscale</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="codicefiscale" name="codicefiscale" value ="<%=loggeduser.getCodicefiscale() %>" />
    	</div>
  	</div>
    <button type="submit" >Aggiorna</button>
</form>
<%
			Object passworderrata = request.getAttribute("errorepassword");
			if(passworderrata != null && ((Boolean)passworderrata))	{
				%>
				<p >Le Password non coincidono.</p>
				<%
			}
		%>

</body>
</html>