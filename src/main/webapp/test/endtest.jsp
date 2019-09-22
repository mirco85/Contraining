<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" %>
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
		
		<div class="main mainContainer">
			<div class="dataContainer">
				<div class="endtestbox">
					<div>
						<p>Test completato</p>
					</div>
					<div class="buttonBox">
						<a href="TestServlet?mode=endtest">Torna alla home</a>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>