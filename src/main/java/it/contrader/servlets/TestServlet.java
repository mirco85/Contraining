package it.contrader.servlets;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dao.login.CredentialsException;
import it.contrader.dto.AnswersDTO;
import it.contrader.dto.CategoryDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.CategoryService;
import it.contrader.service.LoginService;
import it.contrader.service.QuestionService;
import it.contrader.service.AnswersService;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void updateCategoryList(HttpServletRequest request) {
		CategoryService cService = new CategoryService();
		List<CategoryDTO> categories = cService.getAll();
		request.setAttribute("categories", categories);
	}
	
	private List<QuestionDTO> getTestQuestions(int categoryID) {
		List<QuestionDTO> results = (new QuestionService()).getByCategory(categoryID);
		return results;
	}
	
	private void insertAnswer(int questionID, int answerPosition, int userID) {
		AnswersService aService = new AnswersService();
		AnswersDTO dto = new AnswersDTO(userID, questionID, answerPosition);
		aService.insert(dto);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		HttpSession session = request.getSession();
		UserDTO loggedUser = (UserDTO)session.getAttribute("user");
		int idCategory, questionIndex, answerPosition, idQuestion;
		
		
		switch (mode.toUpperCase()) {

		case "SELECTCATEGORY":
			updateCategoryList(request);
			getServletContext().getRequestDispatcher("/test/selectcategory.jsp").forward(request, response);
			break;

		case "STARTTEST":
			idCategory = Integer.parseInt(request.getParameter("idCategory"));
			session.setAttribute("questions", getTestQuestions(idCategory));
			questionIndex = 0;
			request.setAttribute("questionIndex", questionIndex);
			
			getServletContext().getRequestDispatcher("/test/dotest.jsp").forward(request, response);
			
			break;

		case "SUBMITANSWER":
			questionIndex = Integer.parseInt(request.getAttribute("questionIndex").toString());
			answerPosition = Integer.parseInt(request.getAttribute("answerPosition").toString());
			idQuestion = ((List<QuestionDTO>)session.getAttribute("questions")).get(questionIndex).getId();
			insertAnswer(idQuestion, answerPosition, loggedUser.getId());
			questionIndex++;
			request.setAttribute("questionIndex", questionIndex);
			
			if(questionIndex == 20)
				getServletContext().getRequestDispatcher("/test/endtest.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/test/dotest.jsp").forward(request, response);
			
			break;
		case "ENDTEST":
			session.setAttribute("questions", null);
			getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
			break;
		}
	}
	
	

}
