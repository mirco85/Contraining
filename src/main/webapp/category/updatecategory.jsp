<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%CategoryDTO c= (CategoryDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CategoryServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Argument</label>
    </div>
    <div class="col-75">
      <input type="text" id="argument" name="argument" value=<%=c.getArgument()%>>
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>


</body>
</html>