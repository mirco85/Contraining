package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.QuestionsDTO;
import it.contrader.service.QuestionsService;
 

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:4200")

public class QuestionsController extends AbstractController<QuestionsDTO>{
	
	@Autowired
	private QuestionsService questionsService;
	

}
