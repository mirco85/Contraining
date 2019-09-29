<%@ page import="it.contrader.dto.TestDTO" 
		 import="java.util.*"
		 import="it.contrader.dto.CategoryDTO"
%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Insert Answers here</title>
</head>
<body>
	<%@ include file="/css/header.jsp"%>
	<%@ include file="/css/menu.jsp"%>
	<div class="main">
		<%
			List<TestDTO> tests = (List<TestDTO>) request.getSession().getAttribute("testlist");
			List<CategoryDTO> categoryList = (List<CategoryDTO>)request.getSession().getAttribute("categorylist");
		%>

		<br>

		<table>
			<tr>
				<th>Nome test</th>
				<th>Tempo del test (secondi)</th>
				<th>Categoria</th>
				
			</tr>
			<%
				for (TestDTO t : tests) {
			%>
			<tr>
				<td><!-- <a href="/test/read?id=<%=t.getId()%>">--> <%=t.getTestName() %>
				</a></td>
				<td><%=t.getTimeTest() %></td>
				<td>
					<%=t.getCategory().getCategory() %>
				</td>
				
				<td><!-- <a href="/test/preupdate?id=<%=t.getId()%>"-->>Edit (not implemented yet)</a></td>


				<td><a href="/test/delete?id=<%=t.getId()%>">Delete)</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		
		
		
		<form id="floatright" action="/test/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="testname">Test Name</label>
				</div>
				<div class="col-75">
					<input type="text" name="testName" id="testname" placeholder="Nome del test" />
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="timetest">Tempo (in secondi)</label>
				</div>
				<div class="col-75">
					<input type="text" id="timetest" name="timeTest"
						placeholder="inserisci il tempo del test in secondi">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="categories">Categoria</label>
				</div>
				<div class="col-75">
					<select name="idCategory" id="categories">
						<% 
							for(CategoryDTO c : categoryList) {
						%>
						<option value="<%=c.getId() %>"><%=c.getCategory()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>
			

</body>
</html>