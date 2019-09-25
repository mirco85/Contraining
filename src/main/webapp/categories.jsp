<%@ page import="it.contrader.dto.CategoryDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/category/getall">Categories</a> <a href="/category/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CategoryDTO> list = (List<CategoryDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Category</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CategoryDTO u : list) {
			 %>
			<tr>
				<td><a href="/category/read?id=<%=u.getId()%>"> <%=u.getCategory()%>
				</a></td>
				
				<td><a href="/category/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/category/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/category/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Category</label>
				</div>
				<div class="col-75">
					<input type="text" id="category" name="category"
						placeholder="inserisci la categoria">
				</div>
			</div>
			<div class="row">
				
				
			</div>
			<div class="row">
				
				<div class="col-75">
					
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>