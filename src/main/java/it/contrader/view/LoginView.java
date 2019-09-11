package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView extends AbstractView {

	private String username;
	
	private String password;

	public void showResults(Request request) {
		if(request != null) {
			Boolean unknownCredentials = (Boolean)request.get("unknownCredentials");
			if(unknownCredentials != null && unknownCredentials) 
				System.out.println("Le credenziali sono errate.\n");
		}
	}
	/**
	 * chiede in input all'utente uno username e una password usando il metodo getInput() presente in AbstractView
	 */
	public void showOptions() {
		
		System.out.println("----- .:LOGIN:. ----");
		
		System.out.println(" Nome utente:");
		this.username = getInput();
		
		System.out.println(" Password:");
		this.password = getInput();
	}

	/**
	 * Impacchetta una request (metodo request.put("chiave", valore)) e la manda al controller Home tramite il Dispatcher
	 */
	public void submit() {
		
		Request request = new Request();
		
		request.put("username", username);
		request.put("password", password);
		
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
	}


}
