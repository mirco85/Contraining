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
<title>Edit Answer</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%
	AnswersDTO a = (AnswersDTO) request.getAttribute("dto");
	List<UserDTO> users = (List<UserDTO>)request.getAttribute("users");
	List<QuestionDTO> questions = (List<QuestionDTO>)request.getAttribute("questions");
	
%>


<form id="floatleft" action="AnswerServlet?mode=update&id=<%=a.getId()%>" method="post">
  
  <div class="row">
    <div class="col-25">
     <label for="idquestion">Question</label>
    </div>
    <div class="col-75">
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
    <div class="col-25">
      <label for="iduser">Username</label>
    </div>
    <div class="col-75">
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
    <div class="col-25">
      <label for="answer">Answer position</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="answer" name="answer" value=<%=a.getAnswer()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>