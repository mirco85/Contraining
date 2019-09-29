<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
	<%@ include file="./css/menu.jsp"%>
<div class="main">

<%CategoryDTO c = (CategoryDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/category/update" method="post">
	<input type="hidden" value="<%=c.getId() %>" id="id" name="id" />
	<div class="row">
		<div class="col-25">
		  	<label for="category">Nome categoria</label>
		</div>
		<div class="col-75">
			<input type="text" id="category" name="category" value=<%=c.getCategory()%>>
		</div>
	</div>
	
	<button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>