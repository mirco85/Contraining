package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.QuestionsDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.QuestionsService;

@RestController
@RequestMapping("/Questions")

public class QuestionsController {
	
	
	@Autowired
	private QuestionsService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "questions";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "questions";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetext";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("text") String text) {

		QuestionsDTO dto = new QuestionsDTO();
		dto.setId(id);
		dto.setText(text);
		service.update(dto);
		setAll(request);
		return "questions";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("text") String text) {
		QuestionsDTO dto = new QuestionsDTO();
		dto.setText(text);
		service.insert(dto);
		setAll(request);
		return "questions";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readquestions";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("questionslist", service.getAll());
	}

}
