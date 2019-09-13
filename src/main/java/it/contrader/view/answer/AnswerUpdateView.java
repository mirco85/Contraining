package it.contrader.view.answer;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AnswerUpdateView extends AbstractView 
{
	private Request request;

	private int id;
	private int iduser;
	private int idquestion;
	private int answer;
	private final String mode = "UPDATE";
	
	public AnswerUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Answer", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() 
	{
		try 
		{
			System.out.println("Inserisci id della risposta:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id dell'utente:");
			iduser = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id della domanda:");
			idquestion = Integer.parseInt(getInput());
			System.out.println("Inserisci la risposta:");
			answer = Integer.parseInt(getInput());
			
		} 
		catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("iduser", iduser);
		request.put("idquestion", idquestion);
		request.put("answer", answer);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Answers", "doControl", request);
	}


}
