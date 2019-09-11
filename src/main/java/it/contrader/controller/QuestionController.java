package it.contrader.controller;

import it.contrader.dto.QuestionDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.QuestionService;
import java.util.*;

public class QuestionController implements Controller {

	private static String sub_package = "question.";
	private QuestionService questionService;
	
	
	public QuestionController() {
		this.questionService = new QuestionService();
	}
	
	
	@Override
	public void doControl(Request request) {
		String mode = (String)request.get("mode");
		String choice = (String)request.get("choice");
		
		int id;
		String argument, text, answer1, answer2, answer3;
		
		switch(mode) {
		case "READ":
			id = Integer.parseInt(request.get("idQuestion").toString());
			QuestionDTO qDTO = questionService.read(id);
			request.put("question", qDTO);
			MainDispatcher.getInstance().callView(sub_package + "QuestionRead", request);
			break;
			
		case "INSERT":
			argument = request.get("argument").toString();
			text = request.get("text").toString();
			answer1 = request.get("answer1").toString();
			answer2 = request.get("answer2").toString();
			answer3 = request.get("answer3").toString();
			
			QuestionDTO questionToInsert = new QuestionDTO(argument, text, answer1, answer2, answer3);
			questionService.insert(questionToInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "QuestionInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("idQuestion").toString());
			questionService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "QuestionDelete",  request);
			break;
			
		case "QUESTIONLIST":
			List<QuestionDTO> questionDTO = questionService.getAll();
			request.put("questions", questionDTO);
			MainDispatcher.getInstance().callView("Question", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("idQuestion").toString());
			argument = request.get("argument").toString();
			text = request.get("text").toString();
			answer1 = request.get("answer1").toString();
			answer2 = request.get("answer2").toString();
			answer3 = request.get("answer3").toString();
			QuestionDTO questionToUpdate = new QuestionDTO(id, argument, text, answer1, answer2, answer3);
			questionService.update(questionToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "QuestionUpdate", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "QuestionRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "QuestionInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "QuestionUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "QuestionDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
		
		
	}

}
