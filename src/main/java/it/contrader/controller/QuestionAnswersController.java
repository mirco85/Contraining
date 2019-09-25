package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.service.QuestionAnswersService;


@Controller
@RequestMapping("/questionanswers")


public class QuestionAnswersController {
	

	@Autowired
	private QuestionAnswersService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
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
		return "updatetextanswer";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("text") String text, @RequestParam("idquestion") Long idquestion, @RequestParam("right") Boolean right) {

		QuestionAnswersDTO dto = new QuestionAnswersDTO();
		dto.setId(id);
		dto.setText(text);
		dto.setIdquestion(idquestion);
		dto.setRight(right);
		service.update(dto);
		setAll(request);
		return "questionanswers";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("text") String text, @RequestParam("idquestion") Long idquestion, @RequestParam("right") Boolean right) {
		QuestionAnswersDTO dto = new QuestionAnswersDTO();
		dto.setText(text);
		dto.setIdquestion(idquestion);
		dto.setRight(right);
		service.insert(dto);
		setAll(request);
		return "questions";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtext";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("answerlist", service.getAll());
	}

}
