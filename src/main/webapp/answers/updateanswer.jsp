<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Edit Answer</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>


	<div class="main mainContainer">
	
	<%
		AnswersDTO a = (AnswersDTO) request.getAttribute("dto");
		List<UserDTO> users = (List<UserDTO>)request.getAttribute("users");
		List<QuestionDTO> questions = (List<QuestionDTO>)request.getAttribute("questions");
		
	%>
	
	
		<form action="AnswerServlet?mode=update&id=<%=a.getId()%>" method="post">
		  	<div class="formTitle">Aggiorna risposta</div>
		  	<div class="row">
			    <label for="idquestion">Question</label>
			    <div class="inputBox">
			    	<select name="idquestion" id="idquestion">
			    		<%
			    			for(QuestionDTO q : questions) {
			    		%>
			    		<option value="<%=q.getId()%>" <%if(q.getId() == a.getIdquestion()) {%>selected<%} %>><%=q.getText() %></option>
			    		<%
			    			}
			    		%>
			    	</select>
			    </div>
		  	</div>
		  	<div class="row">
			    <label for="iduser">Username</label>
			    <div class="inputBox">
			    	<select name="iduser" id="iduser">
			    	<%
			    		for(UserDTO u : users) {
			    	%>
			    		<option value="<%=u.getId() %>" <%if(a.getIduser() == u.getId()) {%>selected<%}%>><%=u.getUsername() %></option>
			    	<%
			    		}
			    	%>
			    	</select>
			    </div>
		  	</div>
		  	<div class="row">
			    
			    <label for="answer">Answer position</label>
			    <div class="inputBox">
			      	<input type="text" id="answer" name="answer" value=<%=a.getAnswer()%>> 
			    </div>
		  	</div>
		  	<div class="rowButton">
		      	<button type="submit" >Edit</button>
		  	</div>
		</form>
	
		
	</div>

<%@ include file="../css/footer.jsp" %>	
</body>
</html>