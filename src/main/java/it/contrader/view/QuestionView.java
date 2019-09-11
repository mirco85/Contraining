package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.QuestionDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Question;

public class QuestionView extends AbstractView {
	
	private Request request;
	private String choice;
	
	
	public QuestionView() {
	}

	

	public void showResults(Request request) {
	
		
		if (request !=null) {
			
			System.out.println("--------- Gestionedomande del Quiz: ----------\n");
			System.out.println("IDQuestion\tArgument\tText\tAnswer1\tAnswer2\tAnswer3");
			System.out.print("-------------------------------------------------------------\n");
			
			
			List<QuestionDTO> questions = (List<QuestionDTO>) request.get("questions");
			System.out.println();
			
			if(questions != null && questions.size() > 0) {
				for (QuestionDTO q : questions) {
					
					System.out.println(q);
					System.out.println();
				}
			}
			
			
		}
	
	}


	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
	}


	public void submit() {
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Question", "doControl", this.request);
		
	}

}
