package it.contrader.view.question;


import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Question;
import it.contrader.view.AbstractView;
import it.contrader.controller.Request;
import it.contrader.dto.QuestionDTO;

public class QuestionReadView extends AbstractView {
	
	private int idQuestion;
	private Request request;
	private final String mode= "READ";
	
	
	
	public QuestionReadView() {
		new QuestionController();
	}
	
	
	public void showResults(Request request) {
		if (request != null) {
			QuestionDTO question = (QuestionDTO) request.get("question");
			System.out.println(question);
			MainDispatcher.getInstance().callView("Question", null);
			
		}
	}
	
	
	public void showOptions() {
		System.out.println("Inserire l'ID della domanda:");
		idQuestion = Integer.parseInt(getInput());
		
	}
	
	
	public void submit() {
		request = new Request();
		request.put("idQuestion", idQuestion);
		request.put("mode", "READ");
		MainDispatcher.getInstance().callAction("Question", "doControl", request);
	}

}
