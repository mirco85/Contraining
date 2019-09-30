<%@ page import="it.contrader.dto.QuestionAnswersDTO" import="java.util.*"
		 import="it.contrader.model.QuestionAnswers.AnswerType"
		 import="it.contrader.dto.QuestionsDTO" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Insert Answers here</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/menu.jsp"%>
	<div class="main">
		<%
			List<QuestionAnswersDTO> list = (List<QuestionAnswersDTO>) request.getSession().getAttribute("answerlist");
			List<QuestionsDTO> questionlist = (List<QuestionsDTO>)request.getSession().getAttribute("questionlist");
		%>

		<br>

		<table>
			<tr>
				<th>Question</th>
				<th>Answers</th>
				<th>Risposta corretta</th>
				
			</tr>
			<%
				for (QuestionAnswersDTO q : list) {
			%>
			<tr>
				<td><%=q.getQuestion().getText() %></td>
				<td><a href="/questionanswers/read?id=<%=q.getId()%>"> <%=q.getText()%>
				</a></td>
				<td>
					<input type="checkbox" disabled <%if(q.getRightAnswer() == AnswerType.RIGHT) {%>checked<%}%> />
				</td>
				
				<td><a href="/questionanswers/preupdate?id=<%=q.getId()%>">Edit</a></td>


				<td><a href="/questionanswers/delete?id=<%=q.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		
		
		
		<form id="floatright" action="/questionanswers/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="questions">Questions</label>
				</div>
				<div class="col-75">
					<select name="idquestion" id="questions">
						<% for(QuestionsDTO question : questionlist) { %>
						<option value="<%=question.getId()%>"><%=question.getText() %></option>
						<%} %>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="questionanswers">Answers</label>
				</div>
				<div class="col-75">
					<input type="text" id="questionanswers" name="text"
						placeholder="inserisci la risposta">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="rightanswer">Corretta?</label>
				</div>
				<div class="col-75">
					<select name="rightAnswer" id="rightanswer">
						<option value="RIGHT">Corretta</option>
						<option value="WRONG">Non corretta</option>
						
					</select>
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
			

</body>
</html>