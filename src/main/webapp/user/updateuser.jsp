<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>


<div class="main mainContainer">

<%UserDTO u = (UserDTO) request.getAttribute("dto");%>


<form action="UserServlet?mode=update&id=<%=u.getId()%>" method="post">
	<div class="formTitle">Aggiorna utente</div>  
  <div class="row">
    
      <label for="user">Username</label>
    
    <div class="inputBox">
      <input type="text" id="user" name="username" value=<%=u.getUsername()%>>
    </div>
  </div>
  <div class="row">
    
     <label for="pass">Password</label>
    
    <div class="inputBox">
      <input
			type="text" id="pass" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  <div class="row">
    
      <label for="type">Usertype</label>
    
   		 <div class="inputBox">
 			<select id="type" name="usertype">
  				<option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
  				<option value="USER" <%if(u.getUsertype().equals("USER")) {%>selected<%}%>>USER</option>
			</select>
    	</div>
  </div>
  
  	<div class="row">
  		
      		<label for="firstname">Firstname</label>
    	
   		<div class="inputBox">
 			<input type="text" id="firstname" name="firstname" placeholder="Inserire il nome" />
    	</div>
  	</div>
  	<div class="row">
  		
      		<label for="lastname">Lastname</label>
    	
   		<div class="inputBox">
 			<input type="text" id="lastname" name="lastname" placeholder="Inserire il cognome" />
    	</div>
  	</div>
  	<div class="row">
  		
      		<label for="datanascita">Data di nascita</label>
    	
   		<div class="inputBox">
 			<input type="date" id="datanascita" name="datanascita" />
    	</div>
  	</div>
  	<div class="row">
  		
      		<label for="codicefiscale">Codice fiscale</label>
    	
   		<div class="inputBox">
 			<input type="text" id="codicefiscale" name="codicefiscale" placeholder="Inserire il codice fiscale" />
    	</div>
  	</div>
  	<div class="rowButton">
      	<button type="submit" >Edit</button>
  	</div>
</form>

	
</div>

<%@ include file="../css/footer.jsp" %>	
</body>
</html>