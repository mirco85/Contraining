<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<div class="main mainContainer">
	<%
		List<UserDTO> list = (List<UserDTO>) request.getAttribute("list");
	%>
	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Data di nascita</th>
			<th>Codice fiscale</th>
			
			
			<th></th>
			<th></th>
		</tr>
		<%
			for (UserDTO u : list) {
		%>
		<tr>
			<td><a href=UserServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getUsername()%>
			</a>
			</td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			<td><%=u.getFirstname()%></td>
			<td><%=u.getLastname()%></td>
			<td><%=u.getDatanascita()%></td>
			<td><%=u.getCodicefiscale()%></td>
			<td><a href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=UserServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form action="UserServlet?mode=insert" method="post">
	<div class="formTitle">Aggiungi un utente</div>
	<div class="row">
	   	<label for="username">UserName</label>
	    <div class="inputBox">
	      	<input type="text" id="username" name="username" >
	    </div>
  	</div>
    <div class="row">
	    <label for="pass">Password</label>
	    <div class="inputBox">
	      	<input type="text" id="pass" name="password" placeholder="inserisci password"> 
	    </div>
  	</div>
    <div class="row">
    	<label for="type">UserType</label>
	    <div class="inputBox">
	      	<select id="type" name="usertype" > 
		      	<option value ="ADMIN"> Admin</option>
		      	<option value ="USER"> User</option>
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
    	<button type="submit" >Insert</button>
  	</div>
</form>

</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>