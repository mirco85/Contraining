<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.QuestionsDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>

<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%QuestionsDTO q = (QuestionsDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/Questions/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="question">Questions</label>
    </div>
    <div class="col-75">
      <input type="text" id="question" name="question" value=<%=q.getText()%>>
    </div>
  </div>
        <button type="submit" >Edit</button>
</form>

	
</div>
<br>



<%@ include file="./css/footer.jsp" %>
</body>
</html>