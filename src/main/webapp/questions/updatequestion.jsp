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
<title>Edit Questions</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>


<div class="main mainContainer">

<%
	QuestionDTO a = (QuestionDTO)request.getAttribute("dto");
	List<CategoryDTO> category = (List<CategoryDTO>)request.getAttribute("categories");
%>


<form action="QuestionServlet?mode=update&id=<%=a.getId()%>" method="post">
	<div class="formTitle">Aggiorna domanda</div>

  <div class="row">
  		<label for="text">Question Text</label>
    	<div class="inputBox">
 			<input type="text" id="text" name="text"  value ="<%=a.getText() %>" />
    	</div>
  </div>
  <div class="row">
  		<label for="answer1">Answer 1</label>
    	<div class="inputBox">
 			<input type="text" id="answer1" name="answer1"  value ="<%=a.getAnswer1() %>" />
    	</div>
  </div>
  <div class="row">
  		<label for="answer2">Answer 2</label>
    	<div class="inputBox">
 			<input type="text" id="answer2" name="answer2"  value ="<%=a.getAnswer2() %>" />
    	</div>
  </div>
  <div class="row">
  		<label for="answer3">Answer 3</label>
    	<div class="inputBox">
 			<input type="text" id="answer3" name="answer3"  value ="<%=a.getAnswer3() %>" />
    	</div>
  </div>
  <div class="row">
  		<label for="questiontime">Question Time</label>
    	<div class="inputBox">
 			<input type="text" id="questiontime" name="questiontime"  value ="<%=a.getQuestiontime() %>" />
    	</div>
  </div>
    <div class="row">
    
     <label for="idquestion">Argument</label>
    
    <div class="inputBox">
    	<select name="idargument" id="idargument">
    		<%
    			for(CategoryDTO c : category) {
    		%>
    		<option value="<%=c.getId()%>" <%if(c.getId() == a.getIdargument()) {%>selected<%} %>><%=c.getArgument() %></option>
    		<%
    			}
    		%>
    	</select>
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