package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.dto.QuestionsDTO;
import it.contrader.model.QuestionAnswers.AnswerType;
import it.contrader.service.QuestionAnswersService;
import it.contrader.service.QuestionsService;


@Controller
@RequestMapping("/questionanswers")
public class QuestionAnswersController {
	

	@Autowired
	private QuestionAnswersService service;
	
	@Autowired
	private QuestionsService qService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		setAllQuestions(request);
		return "questionanswers";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "questionanswers";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		setAllQuestions(request);
		return "updatetextanswer";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("text") String text, @RequestParam("idquestion") Long idquestion, @RequestParam("rightAnswer") String right) {

		QuestionAnswersDTO dto = new QuestionAnswersDTO();
		dto.setId(id);
		dto.setText(text);
		QuestionsDTO question = qService.read(idquestion);
		dto.setQuestion(question);
		AnswerType a = AnswerType.valueOf(right);
		dto.setRightAnswer(a);
		service.update(dto);
		setAll(request);
		return "questionanswers";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("text") String text, @RequestParam("idquestion") Long idquestion, @RequestParam("rightAnswer") String right) {
		QuestionAnswersDTO dto = new QuestionAnswersDTO();
		AnswerType a = AnswerType.valueOf(right);
		QuestionsDTO question = qService.read(idquestion);
		
		dto.setText(text);
		dto.setQuestion(question);
		dto.setRightAnswer(a);
		
		service.insert(dto);
		
		setAll(request);
		return "questionanswers";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readanswers";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("answerlist", service.getAll());
	}
	private void setAllQuestions(HttpServletRequest request) {
		request.getSession().setAttribute("questionlist", qService.getAll());
	}

}
