<%@ page import="it.contrader.dto.QuestionsDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Insert Questions here</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/menu.jsp"%>
	<div class="main">
		
		<%
			List<QuestionsDTO> list = (List<QuestionsDTO>) request.getSession().getAttribute("questionslist");
		%>
		
		
		<br>

		<table>
			<tr>
				<th>Questions</th>
			</tr>
			
			
			<%
				for (QuestionsDTO q : list) {
			%>
			
			<tr>
				<td><a href="/Questions/read?id=<%=q.getId()%>"> <%=q.getText()%>
				</a></td>
				<td><a href="/Questions/preupdate?id=<%=q.getId()%>">Edit</a></td>
				<td><a href="/Questions/delete?id=<%=q.getId()%>">Delete</a></td>

			</tr>
			
			<%
				}
			%>
		</table>
		
		
		<form id="floatright" action="/Questions/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="question">Questions</label>
				</div>
				<div class="col-75">
					<input type="text" id="question" name="text"
						placeholder="inserisci la domanda">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
			
	
	
	<%@ include file="./css/footer.jsp"%>

</body>
</html>