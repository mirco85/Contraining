package it.contrader.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.ConverterDate;
import it.contrader.dao.login.CredentialsException;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";

	
	public User login (String username, String password) throws CredentialsException {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			
			ResultSet resultSet;
			
			if(statement.executeQuery().next()) {
				resultSet = statement.executeQuery();
				resultSet.next();
				String datanascita, firstname, lastname, codicefiscale;
				String usertype = resultSet.getString("usertype");
				firstname = resultSet.getString("firstname");
				lastname = resultSet.getString("lastname");
				codicefiscale = resultSet.getString("codicefiscale");
				datanascita = ConverterDate.dateToString(resultSet.getDate("datanascita"));
				int id = resultSet.getInt("id");
				User user = new User(id, datanascita, firstname, lastname, username, password, usertype, codicefiscale);
				
				return user;
			} else {
				throw new CredentialsException();
			}
		}
		
		catch (SQLException e) {
			
			return null;
		}
	}
}
