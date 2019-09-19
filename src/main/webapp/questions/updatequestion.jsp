<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Questions</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%
	QuestionDTO a = (QuestionDTO) request.getAttribute("dto");
	List<CategoryDTO> category = (List<CategoryDTO>)request.getAttribute("category");
	QuestionDTO question = (QuestionDTO) session.getAttribute("question");
%>


<form id="floatleft" action="QuestionServlet?mode=update&id=<%=a.getId()%>" method="post">
  
  <div class="row">
    <div class="col-25">
     <label for="idquestion">Argument</label>
    </div>
    <div class="col-75">
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
  <div class="row">
  		<div class="col-25">
      		<label for="text">Question Text</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="text" name="text"  value ="<%=question.getText() %>" />
    	</div>
  </div>
  <div class="row">
  		<div class="col-25">
      		<label for="answer1">Answer 1</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="answer1" name="answer1"  value ="<%=question.getAnswer1() %>" />
    	</div>
  </div>
  <div class="row">
  		<div class="col-25">
      		<label for="answer2">Answer 2</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="answer2" name="answer2"  value ="<%=question.getAnswer2() %>" />
    	</div>
  </div>
  <div class="row">
  		<div class="col-25">
      		<label for="answer3">Answer 3</label>
    	</div>
   		<div class="col-75">
 			<input type="text" id="answer3" name="answer3"  value ="<%=question.getAnswer3() %>" />
    	</div>
  </div>
  <div class="row">
  		<div class="col-25">
      		<label for="questiontime">Question Time</label>
    	</div>
   		<div class="col-75">
 			<input type="time" id="questiontime" name="questiontime"  value ="<%=question.getQuestiontime() %>" />
    	</div>
  </div>
  	

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>