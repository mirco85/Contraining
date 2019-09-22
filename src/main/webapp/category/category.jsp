<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="java.util.List"
    import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/mainstyle.css" rel="stylesheet">
<title>Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<div class="main mainContainer">
	<%
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
	%>

	<table>
		<tr>
			<th>id</th>
			<th>argument</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CategoryDTO c : list) 
			{
		%>
		<tr>
			<td><a href=CategoryServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getId()%>
			</a></td>
			<td><%=c.getArgument()%></td>
			
			<td><a href=CategoryServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CategoryServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
	
	<form action="CategoryServlet?mode=insert" method="post">
		<div class="formTitle">Aggiungi una categoria</div>
		<div class="row">
			<label for="argument">Argument</label>
			<div class="inputBox">
		    	<input type="text" id="argument" name="argument" >
			</div>
	  	</div>
	  	<div class="rowButton">
    		<button type="submit" >Insert</button>
	  	</div>
	</form>
	</div>
	
<%@ include file="../css/footer.jsp" %>
</body>
</html>