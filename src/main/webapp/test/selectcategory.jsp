<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.CategoryDTO"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/mainstyle.css" />
		<link type="text/CSS" href="css/test.css" rel="stylesheet" />
		
	</head>
	<body>
	<%@ include file="../css/header.jsp" %>
	<%@ include file="../menu/menu.jsp" %>
	
	<% List<CategoryDTO> list = (List<CategoryDTO>)request.getAttribute("categories"); %>
		<div class="main mainContainer">
			<div class="dataContainer">
				<form action="TestServlet?mode=starttest" method="post">
					<div class="selectCategoryBox">
						<div>Seleziona categoria</div>
						<div>
							<select id="idCategory" name="idCategory">
								<%
									for(CategoryDTO c : list) {
								%>
								<option value="<%=c.getId()%>"><%=c.getArgument() %></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="buttonBox">
							<button type="submit">Inizia Test</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		
	<%@ include file="../css/footer.jsp" %>
	</body>
</html>