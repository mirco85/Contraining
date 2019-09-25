package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TestQuestionDTO;
import it.contrader.service.TestQuestionService;

@Controller
@RequestMapping("/testquestion")
public class TestQuestionController {

	@Autowired
	private TestQuestionService service;
	
	private void setAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("testquestionlist", service.getAll());
	}
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "tests";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "deletetest";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetest";
	}
	
	@PostMapping("/update") 
	public String update(HttpServletRequest request,@RequestParam("id") Long id, @RequestParam("idTest") Long idTest, @RequestParam("idUser") Long idUser) {
		TestQuestionDTO test = new TestQuestionDTO();
		test.setId(id);
		test.setIdTest(idTest);
		test.setIdUser(idUser);
		service.update(test);
		setAll(request);
		
		return "tests";
	}
	
	@PostMapping("/insert") 
	public String insert(HttpServletRequest request, @RequestParam("idTest") Long idTest, @RequestParam("idUser") Long idUser) {
		TestQuestionDTO test = new TestQuestionDTO();
		test.setIdTest(idTest);
		test.setIdUser(idUser);
		service.insert(test);
		setAll(request);
		
		return "tests";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		TestQuestionDTO test = service.read(id);
		request.getSession().setAttribute("dto", test);
		
		return "testread";
	}
	
}
