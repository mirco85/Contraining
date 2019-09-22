<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Update Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>


	<div class="main mainContainer">
	
		<%CategoryDTO c= (CategoryDTO) request.getAttribute("dto");%>
		<form id="floatleft" action="CategoryServlet?mode=update&id=<%=c.getId()%>" method="post">
			<div class="formTitle">Aggiorna categoria</div>  
		  <div class="row">
			  <label for="user">Argument</label>
			  <div class="inputBox">
			      <input type="text" id="argument" name="argument" value=<%=c.getArgument()%>>
			  </div>
		  </div>
		  <div class="rowButton">
		      <button type="submit" >Edit</button>
		  </div>
		</form>
	</div>

<%@ include file="../css/footer.jsp" %>	
</body>


</body>
</html>