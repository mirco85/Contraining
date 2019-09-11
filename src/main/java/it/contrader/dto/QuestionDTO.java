package it.contrader.dto;

/**
 * 
 * @author Mirco
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class QuestionDTO 
{
	private int id;
	private String argument;
	private String text;
	private String answer1;
	private String answer2;
	private String answer3;
	
	public QuestionDTO() {	
	}
	public QuestionDTO (int id, String argument, String text, String answer1, String answer2, String answer3)
	{
		this.id = id;
		this.argument = argument;
		this.text = text;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	public QuestionDTO (String argument, String text, String answer1, String answer2, String answer3)
	{
		this.argument = argument;
		this.text = text;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArgument() {
		return argument;
	}
	public void setArgument(String argument) {
		this.argument = argument;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String tab = "\t";
		sb.append(id).append(tab)
			.append(argument).append(tab)
			.append(text).append(tab)
			.append(answer1).append(tab)
			.append(answer2).append(tab)
			.append(answer3);
		
		
		return sb.toString();
	}
	
}
	
