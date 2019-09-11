package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.AnswersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;

/**
 * 
 * @author Mirco
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */

public class AnswerView extends AbstractView 
{
	private Request request;
	private String choice;
	
	public AnswerView() {
		
	}
    
	// Mostra la lista delle risposte
	@Override
	public void showResults(Request request) 
	{
		if (request != null) 
		{
			System.out.println("\n------------------- Gestione risposte ----------------\n");
			System.out.println("ID\tID utente\tID question\tAnswer");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<AnswersDTO> answers = (List<AnswersDTO>) request.get("answers");
			for (AnswersDTO a: answers)
				System.out.println(a);
			    System.out.println();
		}
		
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() 
	{
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */

	@Override
	public void submit() 
	{
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Answer", "doControl", this.request);
		
	}
	
	
	
	

}
