package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class UserDAO implements DAO<User> {

	private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_CREATE = "INSERT INTO user (username, password, usertype) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE user SET username=?, password=?, usertype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE id=?";

	public UserDAO() {

	}

	public List<User> getAll() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String datanascita = resultSet.getString("datanascita");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String usertype = resultSet.getString("usertype");
				String codicefiscale = resultSet.getString("codicefiscale");
				user = new User(datanascita, firstname, lastname, username, password, usertype, codicefiscale);
				user.setId(id);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insert(User userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, userToInsert.getDatanascita());
			preparedStatement.setString(2, userToInsert.getFirstname());
			preparedStatement.setString(3, userToInsert.getLastname());
			preparedStatement.setString(4, userToInsert.getUsername());
			preparedStatement.setString(5, userToInsert.getPassword());
			preparedStatement.setString(6, userToInsert.getUsertype());
			preparedStatement.setString(7, userToInsert.getCodicefiscale());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public User read(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String firstname,lastname,username, password, usertype,codicefiscale,datanascita;

			datanascita = resultSet.getString("datanascita");
			firstname = resultSet.getString("firstname");
			lastname = resultSet.getString("lastname");
			username = resultSet.getString("username");
			password = resultSet.getString("password");
			usertype = resultSet.getString("usertype");
			codicefiscale = resultSet.getString("codicefiscale");
			User user = new User(datanascita, firstname, lastname, username, password, usertype, codicefiscale);
			user.setId(resultSet.getInt("id"));

			return user;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getId() == 0)
			return false;

		User userRead = read(userToUpdate.getId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getDatanascita() == null || userToUpdate.getDatanascita().equals("")) {
					userToUpdate.setDatanascita(userRead.getDatanascita());
				}
				
				if (userToUpdate.getFirstname() == null || userToUpdate.getFirstname().equals("")) {
					userToUpdate.setFirstname(userRead.getFirstname());
				}
				
				if (userToUpdate.getLastname() == null || userToUpdate.getLastname().equals("")) {
					userToUpdate.setLastname(userRead.getLastname());
				}
				
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}

				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}

				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				if (userToUpdate.getCodicefiscale() == null || userToUpdate.getCodicefiscale().equals("")) {
					userToUpdate.setCodicefiscale(userRead.getCodicefiscale());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getDatanascita());
				preparedStatement.setString(2, userToUpdate.getFirstname());
				preparedStatement.setString(3, userToUpdate.getLastname());
				preparedStatement.setString(4, userToUpdate.getUsername());
				preparedStatement.setString(5, userToUpdate.getPassword());
				preparedStatement.setString(6, userToUpdate.getUsertype());
				preparedStatement.setString(7, userToUpdate.getCodicefiscale());
				preparedStatement.setInt(8, userToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
