<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.QuestionDTO"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Questions</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>

<div class="main">
<%QuestionDTO a = (QuestionDTO) request.getAttribute("dto");%>
<table>
	<tr> 
		<th>id</th>
		<th>Argument</th>
		<th>Question Text</th>
		<th>Answer 1</th>
		<th>Answer 2</th>
		<th>Answer 3</th>
		<th>Question Time</th>
	</tr>
	<tr>
		<td><%=a.getId()%></td>
		<td><%=a.getArgument()%></td>
		<td><%=a.getText()%></td>
		<td><%=a.getAnswer1()%></td>
		<td><%=a.getAnswer2()%></td>
		<td><%=a.getAnswer3()%></td>
		<td><%=a.getQuestiontime()%></td>
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