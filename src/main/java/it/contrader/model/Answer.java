package it.contrader.model;

public class Answer 
{
	// dichiaro le variabili della classe Answer
		private int id;
		private int iduser;
		private int idquestion;
		private int answer;
		
		// Costruttore vuoto
		public Answer() {	
		}
		
		// Costruttore con parametri
		public Answer(int iduser,int idquestion,int answer) {
			
			this.iduser = iduser;
			this.idquestion = idquestion;
			this.answer = answer;
		}

		public Answer(int id, int iduser, int idquestion, int answer) {
			this.id = id;
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

		public String toString() {
			return  id + "\t"  + iduser +"\t\t" +   idquestion + "\t\t" + answer;
		}
}