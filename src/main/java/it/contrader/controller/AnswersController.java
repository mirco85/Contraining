package it.contrader.controller;

import java.util.List;

import it.contrader.dto.AnswersDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.AnswersService;

public class AnswersController implements Controller {
	
	private static String sub_package = "answer.";
	
	private AnswersService answersservice;
	
	public  AnswersController() {
		this.answersservice = new AnswersService();
	
}
	
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		int iduser;
		int idquestion;
		int answer;
		
		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			AnswersDTO answersDTO = answersservice.read(id);
			request.put("answers", answersDTO);
			MainDispatcher.getInstance().callView(sub_package + "AnswerRead" , request);
			break;
			
		case "INSERT":
		  iduser = Integer.parseInt(request.get("iduser").toString());
		  idquestion = Integer.parseInt(request.get("idquestion").toString());
		  answer = Integer.parseInt(request.get("answer").toString());
		  
		  AnswersDTO answertoinsert = new AnswersDTO(iduser, idquestion, answer);
		  
		  answersservice.insert(answertoinsert);
		  request= new Request ();
		  request.put("mode", "mode");
		  
		  MainDispatcher.getInstance().callView(sub_package + "AnswerInsert", request);
		  break;
		  
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			answersservice.delete(id);
			request= new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AnswerDelete",request );
			break;
			
		case "UPDATE":
			id= Integer.parseInt(request.get("id").toString());
			iduser = Integer.parseInt(request.get("iduser").toString());
			idquestion = Integer.parseInt(request.get("idquestion").toString());
			answer = Integer.parseInt( request.get("answer").toString());
			AnswersDTO answertoupdate = new AnswersDTO (iduser, idquestion, answer);
			answertoupdate.setId(id);
			answersservice.update(answertoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AnswerUpdate", request);
			break;
			
		case "ANSWERLIST":
			List<AnswersDTO> answerDTO = answersservice.getAll();
			request.put("answers", answerDTO);
			MainDispatcher.getInstance().callView("Answer", request);
			break;	
		
		case "GETCHOICE":
			
			switch (choice.toUpperCase()) {
			
			case "A":
				List<AnswersDTO> answerDTO2 = answersservice.getAll();
				request.put("answers", answerDTO2);
				MainDispatcher.getInstance().callView("Answer", request);
				break;
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package  + "AnswerRead",null );
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package  + "AnswerInsert",null );
			    break;
			    
			case "M":
				MainDispatcher.getInstance().callView(sub_package  + "AnswerUpdate",null );
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package  + "AnswerDelete",null );
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


