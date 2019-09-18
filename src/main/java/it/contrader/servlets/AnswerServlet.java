package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import it.contrader.dto.AnswersDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AnswersService;
import it.contrader.service.QuestionService;
import it.contrader.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AnswerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public AnswerServlet() {
	}

	public void updateList(HttpServletRequest request) {
		AnswersService service = new AnswersService();
		List<AnswersDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnswersService service = new AnswersService();
		String mode = request.getParameter("mode");
		AnswersDTO dto;
		
		int id;
		int iduser;
		int idquestion;
		int answer;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ANSWERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/answers/answermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/answers/readanswer.jsp").forward(request, response);
				
			} else {
				List<UserDTO> users = (new UserService()).getAll();
				List<QuestionDTO> questions = (new QuestionService()).getAll();
				request.setAttribute("users", users);
				request.setAttribute("questions", questions);
				getServletContext().getRequestDispatcher("/answers/updateanswer.jsp").forward(request, response);
			}
			
			break;

		case "INSERT":
			iduser = Integer.parseInt(request.getParameter("iduser").toString());
			idquestion = Integer.parseInt(request.getParameter("idquestion").toString());
			answer = Integer.parseInt(request.getParameter("answer").toString());
			dto = new AnswersDTO (iduser,idquestion,answer);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/answers/answermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			iduser = Integer.parseInt(request.getParameter("iduser"));
			idquestion = Integer.parseInt(request.getParameter("idquestion"));
			answer = Integer.parseInt(request.getParameter("answer"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new AnswersDTO (id,iduser, idquestion, answer);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/answers/answermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/answers/answermanager.jsp").forward(request, response);
			break;
		}
	}

}
