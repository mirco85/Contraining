package it.contrader.dto;

import java.sql.Date;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class UserDTO {
	
	private int id;
	
	private String datanascita;
	
	private String firstname;
	
	private String lastname;

	private String username;
	
	private String password;
	
	private String usertype;
	
	private String codicefiscale;

	
	public UserDTO() {
		
	}

	public UserDTO (String datanascita, String firstname, String lastname, String username, String password, String usertype, String codicefiscale) {
		this.setDatanascita(datanascita);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.setCodicefiscale(codicefiscale);		
	}

	public UserDTO (int id, String datanascita, String firstname, String lastname, String username, String password, String usertype, String codicefiscale) {
		this.id = id;
		this.setDatanascita(datanascita);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.setCodicefiscale(codicefiscale);	
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(String datanascita) {
		this.datanascita = datanascita;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	
	@Override
	public String toString() {
		return  id + "\t" + datanascita + "\t\t" + firstname + "\t\t" + lastname + "\t\t" + username +"\t\t" +   password + "\t\t" + usertype + "\t\t" + codicefiscale;
	}


}
