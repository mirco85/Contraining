<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Profilo Utente</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<% UserDTO loggeduser = (UserDTO) session.getAttribute("user"); %>
<div>
	<div>
      	<div>USER PROFILE</div>
      	<table>
      		<tr>
      			<td>
      				USERNAME
      			</td>
      			<td>
      			
      				<%= loggeduser.getUsername() %>
      			</td>
      			
      		</tr>
      		<tr>
      		    <td>
      		    	FIRSTNAME 
      			</td>
      			<td>
      				<%= loggeduser.getFirstname()%>
      			</td>
      		</tr>
      		<tr>
      		   	<td>
      		   		LASTNAME
      		   	
      			</td>
      			<td>
      				<%= loggeduser.getLastname() %>
      			</td>
      			
      		</tr>
      		<tr>
      		    <td>
      		    	DATA DI NASCITA
      			</td>
      			<td>
      				<%=loggeduser.getDatanascita() %>
      			</td>
      		</tr>
      		<tr>
      		
      		    <td>
      		    	CODICE FISCALE
      			</td>
      			<td>
      				<%=loggeduser.getCodicefiscale() %>
      			</td>
      		</tr>
      	</table>
      	<div>
      		<a href="UserServlet?mode=edituserprofile">Modifica Account</a>
      		<a href="UserServlet?mode=deleteuserprofile&id=<%=loggeduser.getId()%>">Elimina Account</a>
      	</div>
	</div>

</div>

</body>
</html>