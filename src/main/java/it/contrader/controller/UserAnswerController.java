package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserAnswersDTO;
import it.contrader.service.UserAnswersService;


@Controller
@RequestMapping("/useranswers")

public class UserAnswerController {
	@Autowired
	private UserAnswersService service;
	
	
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "useranswers";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "useranswers";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateuseranswers";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("idanswer") Long idanswer,
			@RequestParam("iduser") Long iduser, @RequestParam("idtest")Long idtest,@RequestParam("numtest")Long numtest) {

		UserAnswersDTO dto = new UserAnswersDTO();
		dto.setId(id);
		dto.setIdanswer(idanswer);
		dto.setIdtest(idtest);;
		dto.setIduser(iduser);
		dto.setNumtest(numtest);
		service.update(dto);
		setAll(request);
		return "useranswers";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,@RequestParam("id") Long id, @RequestParam("idanswer") Long idanswer,
			@RequestParam("iduser") Long iduser, @RequestParam("idtest")Long idtest,@RequestParam("numtest")Long numtest ) {
		UserAnswersDTO dto = new UserAnswersDTO();
		dto.setId(id);
		dto.setIdanswer(idanswer);;
		dto.setIdtest(idtest);
		dto.setIduser(iduser);
	    dto.setNumtest(numtest);
		service.insert(dto);
		setAll(request);
		return "useranswers";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readuseranswers";
	}

	

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	

}
