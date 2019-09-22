<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1"
	import="java.util.List"
	import="it.contrader.dto.QuestionDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/mainstyle.css" />
		<link type="text/CSS" href="css/test.css" rel="stylesheet" />
	</head>
	<body>
		<% 	List<QuestionDTO> list = (List<QuestionDTO>)session.getAttribute("questions"); 
			Integer questionIndex = Integer.parseInt(request.getAttribute("questionIndex").toString());
			QuestionDTO question = list.get(questionIndex);
		%>
		
		<%@ include file="../css/header.jsp" %>
		<%@ include file="../menu/menu.jsp" %>
		
		<div class="main mainContainer">
			<div class="dataContainer">
				<form action="TestServlet?mode=submitanswer" method="post">
					<div class="questionBox">
						<div>
							<p class="QuestionText"><%=question.getText()%></p>
						</div>
						<div class="choice">
							<input type="radio" value="1" name="answerPosition" /><%=question.getAnswer1() %>
						</div>
						<div class="choice">
							<input type="radio" value="2" name="answerPosition"/><%=question.getAnswer2() %>
						</div>
						<div class="choice">
							<input type="radio" value="3" name="answerPosition"/><%=question.getAnswer3() %>
						</div>
						<div class="buttonBox">
							<input type="hidden" name="questionIndex" id="questionIndex" value="<%=questionIndex.toString() %>" />
							<button type="submit">Invia risposta</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>