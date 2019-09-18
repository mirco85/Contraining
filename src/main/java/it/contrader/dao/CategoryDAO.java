package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Category;

import it.contrader.utils.ConnectionSingleton;

public class CategoryDAO implements DAO<Category>{
	
	private final String QUERY_ALL = "SELECT * FROM category";
	private final String QUERY_CREATE = "INSERT INTO category (argument) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM category WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE category SET argument=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM category WHERE id=?";
	
	
	public CategoryDAO() {
		
		
	}
	
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Category category;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String argument = resultSet.getString("argument");
				category = new Category(argument);
				category.setId(id);
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	
	public boolean insert(Category categoryToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, categoryToInsert.getArgument());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Category read(int categoryId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String argument;

			argument = resultSet.getString("argument");
			Category category = new Category(argument);
			category.setId(resultSet.getInt("id"));

			return category;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Category categoryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (categoryToUpdate.getId() == 0)
			return false;

		Category categoryRead = read(categoryToUpdate.getId());
		if (!categoryRead.equals(categoryToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (categoryToUpdate.getArgument() == null || categoryToUpdate.getArgument().equals("")) {
					categoryToUpdate.setArgument(categoryRead.getArgument());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, categoryToUpdate.getArgument());
				preparedStatement.setInt(2, categoryToUpdate.getId());
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
