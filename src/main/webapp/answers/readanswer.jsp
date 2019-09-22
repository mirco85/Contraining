<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AnswersDTO"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Read Answer</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

	<div class="main mainContainer">
	<%AnswersDTO a = (AnswersDTO) request.getAttribute("dto");%>
		<table>
			<tr> 
				<th>id</th>
				<th>Domanda</th>
				<th>Username</th>
				<th>Answer Position</th>
			</tr>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getQuestiontext()%></td>
				<td> <%=a.getUsername()%></td>
				<td> <%=a.getAnswer()%></td>
			</tr>
		</table>
	</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>