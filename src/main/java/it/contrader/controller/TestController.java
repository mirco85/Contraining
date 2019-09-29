package it.contrader.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.TestDTO;
import it.contrader.model.Category;
import it.contrader.service.CategoryService;
import it.contrader.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService service;
	@Autowired
	private CategoryService categoryService;
	
	private void setAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("testlist", service.getAll());
	}
	private void setAllCategories(HttpServletRequest request) {
		request.getSession().setAttribute("categorylist", categoryService.getAll());
	}
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		setAllCategories(request);
		return "tests";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		setAllCategories(request);
		return "tests";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("test", service.read(id));
		setAllCategories(request);
		return "updatetest";
	}
	
	@PostMapping("/update") 
	public String update(HttpServletRequest request, @RequestParam("id") Long id, 
			@RequestParam("idCategory") Long idCategory, 
			@RequestParam("timeTest") Long timeTest,
			@RequestParam("testName") String testName) {
		TestDTO test = new TestDTO();
		CategoryDTO c = categoryService.read(idCategory);
		
		test.setId(id);
		test.setCategory(c);
		test.setTimeTest(timeTest);
		test.setTestName(testName);
		service.update(test);
		setAll(request);
		setAllCategories(request);
		
		return "tests";
	}
	
	@PostMapping("/insert") 
	public String insert(HttpServletRequest request, 
			@RequestParam("idCategory") Long idCategory, 
			@RequestParam("timeTest") Long timeTest,
			@RequestParam("testName") String testName) {
		TestDTO test = new TestDTO();
		CategoryDTO c = categoryService.read(idCategory);
		
		test.setCategory(c);
		test.setTimeTest(timeTest);
		test.setTestName(testName);
		service.insert(test);
		setAll(request);
		setAllCategories(request);
		
		return "tests";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		TestDTO test = service.read(id);
		request.getSession().setAttribute("test", test);
		
		return "testread";
	}
	
}
