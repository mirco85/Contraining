package it.contrader.model;
import java.sql.Date;
import java.text.SimpleDateFormat;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class User {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;
	
	private String datanascita;
	
	private String firstname;
	
	private String lastname;

	private String username;
	
	private String password;
	
	private String usertype;
	
	private String codicefiscale;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public User() {
		
	}

	public User (String datanascita, String firstname, String lastname, String username, String password, String usertype, String codicefiscale) {
		this.datanascita = datanascita;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.codicefiscale = codicefiscale;
	}

	public User (int id, String datanascita, String firstname, String lastname, String username, String password, String usertype, String codicefiscale) {
		this.id = id;
		this.datanascita = datanascita;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.codicefiscale = codicefiscale;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDatanascita() {
		return this.datanascita;
	}
	
	public void setDatanascita(String datanascita) {
		this.datanascita = datanascita;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public String getCodicefiscale() {
		return this.codicefiscale;
	}
	
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t" + datanascita + "\t" + firstname + "\t" + lastname + "\t" + username +"\t\t" +   password + "\t\t" + usertype + "\t" + codicefiscale;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (datanascita == null) {
			if (other.datanascita != null)
				return false;
		} else if (!datanascita.equals(other.datanascita))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (codicefiscale == null) {
			if (other.codicefiscale != null)
				return false;
		} else if (!codicefiscale.equals(other.codicefiscale))
			return false;
		return true;
	}
}
