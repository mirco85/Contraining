package it.contrader.dto;

public class AnswersDTO {
      
	private int id;
	
	private int iduser;
	
	private int idquestion;
	
	private int answer;
	
	private String username, questiontext;

	public AnswersDTO() {
		super();
	}

	public AnswersDTO(int id, int iduser, int idquestion, int answer) {
		this.id = id;
		this.iduser = iduser;
		this.idquestion = idquestion;
		this.answer = answer;
	}

	public AnswersDTO(int iduser, int idquestion, int answer) {
		this.iduser = iduser;
		this.idquestion = idquestion;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIdquestion() {
		return idquestion;
	}

	public void setIdquestion(int idquestion) {
		this.idquestion = idquestion;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getQuestiontext() {
		return questiontext;
	}

	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}


	@Override
	public String toString() {
		return id + "\t" + iduser  + "\t\t " + idquestion + "\t\t " + answer;
		
	}
	
	
	
}