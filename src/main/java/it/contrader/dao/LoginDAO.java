package it.contrader.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.dao.login.CredentialsException;
import it.contrader.main.ConnectionSingleton;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";

	
	public String login (String username, String password) throws CredentialsException {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			String usertype = null;
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				//resultSet = statement.executeQuery();
				//resultSet.next();
				usertype = resultSet.getString("usertype");
			} else {
				throw new CredentialsException();
			}

			return usertype;
		}
		
		catch (SQLException e) {
			
			return null;
		}
	}
}
