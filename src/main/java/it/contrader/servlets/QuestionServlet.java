package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.QuestionDTO;
import it.contrader.service.QuestionService;

public class QuestionServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 public QuestionServlet() {

}
 
public void updateList(HttpServletRequest request) {
	QuestionService service = new QuestionService();
	List<QuestionDTO> listDTO = service.getAll();
	request.setAttribute("list", listDTO);
}

@Override

public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 QuestionService service = new QuestionService();
 String mode = request.getParameter("mode");
 QuestionDTO dto;
 int id;
 boolean ans;
 
 switch (mode.toUpperCase()) {
 
 case "QUESTIONLIST":
	 updateList(request);
	 getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request,response);
	 break;
	 
 case "READ":
	 id = Integer.parseInt(request.getParameter("questionid"));
	dto = service.read(id);
	 request.setAttribute("dto",dto);
	 
	 if(request.getParameter("update") == null) {
		 getServletContext().getRequestDispatcher("/question/readquestion.jsp").forward(request,  response);
		 
	 }
	 else getServletContext().getRequestDispatcher("/questions/updatequestion.jsp").forward(request,  response);
	 
	 break;
	 
 case "INSERT":
	 String idargument = request.getParameter("idargument").toString();
	 String text = request.getParameter("text").toString();
	 String answer1 = request.getParameter("answer1").toString();
	 String answer2 = request.getParameter("answer2").toString();
	 String answer3 = request.getParameter("answer3").toString();
	 dto = new QuestionDTO (idargument,text,answer1,answer2,answer3);
	 ans = service.insert(dto);
	 request.setAttribute("ans", ans);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
	 break;
	 
 case "UPDATE":
	 idargument = request.getParameter("idargument");
	 text = request.getParameter("text");
	 answer1 = request.getParameter("answer1");
	 answer2 = request.getParameter("answer2");
	 answer3 = request.getParameter("answer3");
	 id = Integer.parseInt(request.getParameter("id"));
	 dto = new QuestionDTO (idargument,text,answer1,answer2,answer3);
	 ans = service.update(dto);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
	 break;
	
 case "DELETE":
	 id = Integer.parseInt(request.getParameter("id"));
	 ans = service.delete(id);
	 request.setAttribute("ans", ans);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request,  response);
	 break;
	
 }
 
}



}

