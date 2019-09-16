package it.contrader.model;

public class Question {
	
	private int id;
	
	private int idargument;
	
	private String text;
	
	private String answer1;
	
	private String answer2;
	
	private String answer3;
	
	
	
	public Question() { 
}

	public Question(int idargument, String text, String answer1, String answer2, String answer3) {
		this.idargument = idargument;
		this.text = text;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	
	public Question (int id, int idargument, String text, String answer1, String answer2, String answer3) {
		
		this.id = id;
		this.idargument = idargument;
		this.text = text ;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdArgument() {
		return this.idargument;
	}
	public void setIdArgument(int idargument) {
		this.idargument = idargument;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswer1() {
		return this.answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return this.answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return this.answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	
	public String toString() {
		return id + "\t" + idargument + "\t\t" + text + "\t\t" + answer1 + "\t\t" + answer2 + "\t\t" + answer3;
	}

}
