<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AnswersDTO"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%AnswersDTO a = (AnswersDTO) request.getAttribute("dto");%>
<table>
	<tr> 
		<th>id</th>
		<th>Id question</th>
		<th>Id utente</th>
		<th>Answer</th>
	</tr>
	<tr>
		<td><%=a.getId()%></td>
		<td><%=a.getIdquestion()%></td>
		<td> <%=a.getIduser()%></td>
		<td> <%=a.getAnswer()%></td>
	</tr>	
	<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>
</table>