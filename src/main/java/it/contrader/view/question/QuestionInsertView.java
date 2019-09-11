package it.contrader.view.question;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class QuestionInsertView extends AbstractView{
	
	private Request request;
	private String argument,text,answer1,answer2,answer3;
	private final String mode ="INSERT";
	
	
	
	
	public QuestionInsertView() {
		
	}
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Question", null);
		}
	}
	
	public void showOptions() {
		System.out.println("Inserisci l'argomento della domanda :");
		argument = getInput();
		System.out.println("Inserisci il testo della domanda:");
		text = getInput();
		System.out.println("Inserisci answer1 della domanda:");
		answer1 = getInput();
		System.out.println("Inserisci answer2 della domanda:");
		answer2 = getInput();
		System.out.println("Inserisci answer3 della domanda:");
		answer3 = getInput();
}
	
	public void submit() {
		request = new Request();
		request.put("argument", argument);
		request.put("text", text);
		request.put("answer1", answer1);
		request.put("answer2", answer2);
		request.put("answer3", answer3);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Question", "doControl", request);
	}
}
