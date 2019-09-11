package it.contrader.view.answer;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AnswerInsertView extends AbstractView
{
	private Request request;

	private int id;
	private int iduser;
	private int idquestion;
	private int answer;
	private final String mode = "INSERT";

	public AnswerInsertView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) 
	{
		if (request != null) 
		{
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Answer", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() 
	{
			System.out.println("Inserisci l'id dell'utente:");
			iduser = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id della domanda:");
			idquestion = Integer.parseInt(getInput());
			System.out.println("Inserisci la risposta:");
			answer = Integer.parseInt(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("iduser", iduser);
		request.put("idquestion", idquestion);
		request.put("answer", answer);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Answer", "doControl", request);
	}
}
