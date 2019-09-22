<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>


	<div class="main mainContainer">
	<%CategoryDTO c = (CategoryDTO) request.getAttribute("dto");%>
	
	
		<table>
			<tr> 
				<th>Argument</th>
			</tr>
			<tr>
				<td><%=c.getArgument()%></td>
			</tr>	
		</table>
	
	</div>

<%@ include file="../css/footer.jsp" %>




</body>
</html>