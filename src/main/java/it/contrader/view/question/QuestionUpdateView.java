package it.contrader.view.question;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class QuestionUpdateView extends AbstractView {
	
	
	private int idQuestion;
	private String argument;
	private String text;
	private String answer1;
	private String answer2;
	private String answer3;
	private Request request;
	
	public QuestionUpdateView() {}
	
	
	public void showResults(Request request) {
		
		if (request!=null) {
			System.out.println("La modifica è andata a buon fine. \n");
			MainDispatcher.getInstance().callView("Question", null);
		}
	}
	
	
	public void showOptions() {
		System.out.println("Inserire l'ID della domanda da modificare");
		idQuestion=Integer.parseInt(getInput().toString());
		System.out.println("Inserire l'argomento:");
		argument=getInput().toString();
		System.out.println("Inserire il testo della domanda:");
		text=getInput().toString();
		System.out.println("Inserire la prima risposta:");
		answer1=getInput().toString();
		System.out.println("Inserire la seconda risposta:");
		answer2=getInput().toString();
		System.out.println("Inserire la terza risposta:");
		answer3=getInput().toString();
		
	}
	
	
	public void submit() {
		request= new Request();
		request.put("idQuestion", idQuestion);
		request.put("argument", argument);
		request.put("text", text);
		request.put("answer1", answer1);
		request.put("answer2", answer2);
		request.put("answer3", answer3);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Question", "doControl", request);
	}
	

}
