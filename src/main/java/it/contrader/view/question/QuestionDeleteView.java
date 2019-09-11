package it.contrader.view.question;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class QuestionDeleteView extends AbstractView {
	
	
	
	int idquestion;
	private final String mode="DELETE";
	
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Question",null);
		}
		
	}
	
	
	public void showOptions() {
		System.out.println("Inserire l'ID del question da eliminare:\n");
		idquestion=Integer.parseInt(getInput());
	
	}
	
	
	public void submit() {
		Request request = new Request();
		request.put("mode", mode);
		request.put("idQuestion", idquestion);
		MainDispatcher.getInstance().callAction("Question", "doControl", request);
		
	}

}
