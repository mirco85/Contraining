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
<%List<UserAnswersDTO> list =(List<UserAnswersDTO>) request.getSession().getAttribute("list") ;%>

<table>

    <tr>  
           
           <th>Answers</th>
           
           
           
     </tr>
      <%
      for(UserAnswersDTO ua :list){
      %>
      
      <tr>
          <td><a href ="/useranswers/read?id=<%= ua.getId() %>"><%=ua.getIdanswer() %>
          </a></td>
          
          <td><a href="/useranswers/preupdate?id=<%= ua.getId() %>" >Edit</a>
          
          </td>
           <td><a href="/useranswers/delete?id=<%= ua.getId() %>" >Delete</a>
           
           </td>
           
           </tr>
           
           <%
           
            }
           %>
          
</table>
</div>
<br>

<%@ include file="./css/footer.jsp" %>

</body>
</html>