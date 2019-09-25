package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TestDTO;
import it.contrader.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService service;
	
	private void setAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("testlist", service.getAll());
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
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("idCategory") Long idCategory, @RequestParam("timeTest") Long timeTest) {
		TestDTO test = new TestDTO();
		test.setId(id);
		test.setIdCategory(idCategory);
		test.setTimeTest(timeTest);
		service.update(test);
		setAll(request);
		
		return "tests";
	}
	
	@PostMapping("/insert") 
	public String insert(HttpServletRequest request, @RequestParam("idCategory") Long idCategory, @RequestParam("timeTest") Long timeTest) {
		TestDTO test = new TestDTO();
		test.setIdCategory(idCategory);
		test.setTimeTest(timeTest);
		service.insert(test);
		setAll(request);
		
		return "tests";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		TestDTO test = service.read(id);
		request.getSession().setAttribute("dto", test);
		
		return "userread";
	}
	
}
