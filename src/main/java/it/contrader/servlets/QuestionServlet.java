package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.service.CategoryService;
import it.contrader.service.QuestionService;

public class QuestionServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 public QuestionServlet() {

}
 
public void updateList(HttpServletRequest request) {
	QuestionService service = new QuestionService();
	List<QuestionDTO> listDTO = service.getAll();
	request.setAttribute("list", listDTO);
	
	CategoryService categoryService = new CategoryService();
	List<CategoryDTO> categories = categoryService.getAll();
	request.setAttribute("categories", categories);
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
	 getServletContext().getRequestDispatcher("/questions/questionmanager.jsp").forward(request,response);
	 break;
	 
 case "READ":
	 id = Integer.parseInt(request.getParameter("id"));
	 dto = service.read(id);
		 System.out.println(dto);
	 request.setAttribute("dto",dto);
	 
	 if(request.getParameter("update") == null) {
		 getServletContext().getRequestDispatcher("/questions/readquestion.jsp").forward(request,  response);
		 
	 }
	 else {
		 updateList(request);
		 getServletContext().getRequestDispatcher("/questions/updatequestion.jsp").forward(request,  response);
	 }
	 
	 break;
	 
 case "INSERT":
	 int idargument = Integer.parseInt(request.getParameter("idargument").toString());
	 String text = request.getParameter("text").toString();
	 String answer1 = request.getParameter("answer1").toString();
	 String answer2 = request.getParameter("answer2").toString();
	 String answer3 = request.getParameter("answer3").toString();
	 int questiontime = Integer.parseInt(request.getParameter("questiontime").toString());
	 dto = new QuestionDTO (idargument,text,answer1,answer2,answer3,questiontime);
	 ans = service.insert(dto);
	 request.setAttribute("ans", ans);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/questions/questionmanager.jsp").forward(request, response);
	 break;
	 
 case "UPDATE":
	 idargument = Integer.parseInt(request.getParameter("idargument"));
	 text = request.getParameter("text");
	 answer1 = request.getParameter("answer1");
	 answer2 = request.getParameter("answer2");
	 answer3 = request.getParameter("answer3");
	 id = Integer.parseInt(request.getParameter("id"));
	 questiontime = Integer.parseInt(request.getParameter("questiontime"));
	 dto = new QuestionDTO (idargument,text,answer1,answer2,answer3,questiontime);
	 dto.setId(id);
	 ans = service.update(dto);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/questions/questionmanager.jsp").forward(request, response);
	 break;
	
 case "DELETE":
	 id = Integer.parseInt(request.getParameter("id"));
	 ans = service.delete(id);
	 request.setAttribute("ans", ans);
	 updateList(request);
	 getServletContext().getRequestDispatcher("/questions/questionmanager.jsp").forward(request,  response);
	 break;
	
 }
 
}



}

