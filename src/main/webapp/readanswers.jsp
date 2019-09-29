<%@ page import="it.contrader.dto.QuestionAnswersDTO" import="java.util.*"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="UserAnswer Management">

<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Answers Read</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/menu.jsp"%>
	<br>
		
	<div class="main">
	<%QuestionAnswersDTO q = (QuestionAnswersDTO) request.getSession().getAttribute("dto"); ;%>
	
	<table>
			<tr>
				<th>ID</th>
				<th>Questions</th>
			</tr>
			<tr>
				<td><%=q.getId()%></td>
				<td><%=q.getText()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>

</body>
</html>