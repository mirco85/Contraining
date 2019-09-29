<%@ page import="it.contrader.dto.UserAnswersDTO" import="java.util.*"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="UserAnswer Management">

<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Answer</title>
</head>

<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/menu.jsp"%>
	<br>
	
<div class="main">
<%List<UserAnswersDTO> lista =(List<UserAnswersDTO>) request.getSession().getAttribute("lista") ;%>

<table>

    <tr>  
           
           <th>Answers</th>
           
           
           
     </tr>
      <%
      for(UserAnswersDTO ua :lista){
      %>
      
      <tr>
          <td><a href ="/useranswer/read?id=<%= ua.getId() %>"><%=ua.getIdanswer() %>
          </a></td>
          
          <td><a href="/useranswer/preupdate?id=<%ua.getId() %>" >Edit</a>
          
          </td>
           <td><a href="/useranswer/delete?id=<%ua.getId() %>" >Delete</a>
           
           </td>
           
           </tr>
           
           <%
           
            }
           %>
          
</table>

<form id="floatright" action="/useranswer/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="useranswer">Answers</label>
				</div>
				<div class="col-75">
					<input type="text" id="useranswer" name="useranswer"
						placeholder="inserisci la risposta">
				</div>


</div>

</form>
</div>
<br>

<%@ include file =" ./css/footer.jsp" %>

</body>
</html>