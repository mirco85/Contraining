<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>



	<div class="main mainContainer">
	<%UserDTO u = (UserDTO) request.getAttribute("dto");%>

		<table>
			<tr> 
				<th>Username</th>
				<th>Password</th>
				<th>Usertype</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Data di nascita</th>
				<th>Codice fiscale</th>
			</tr>
			<tr>
				<td><%=u.getUsername()%></td>
				<td> <%=u.getPassword()%></td>
				<td> <%=u.getUsertype()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getDatanascita()%></td>
				<td><%=u.getCodicefiscale()%></td>
			</tr>	
		</table>
	</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>