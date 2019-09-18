<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.AnswersDTO"%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
	
<div class="main">
	<%
		List<AnswersDTO> list = (List<AnswersDTO>) request.getAttribute("list");
	%>

<br>
	<table>
		<tr>
			<th>id</th>
			<th>Question</th>
			<th>Username</th>
			<th>Answer</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (AnswersDTO a : list) 
			{
		%>
		<tr>
			<td><a href=AnswerServlet?mode=read&id=<%=a.getId()%>>
					<%=a.getId()%>
			</a></td>
			<td><%=a.getQuestiontext()%></td>
			<td><%=a.getUsername()%></td>
			<td><%=a.getAnswer()%></td>
			<td><a href=AnswerServlet?mode=read&update=true&id=<%=a.getId()%>>Edit</a>
			</td>
			<td><a href=AnswerServlet?mode=delete&id=<%=a.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
	</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>