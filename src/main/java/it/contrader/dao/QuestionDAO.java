package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Question;
import it.contrader.model.User;

public class QuestionDAO implements DAO<Question>{
	
	
	private final String QUERY_ALL = "SELECT * FROM questions";
	private final String QUERY_CREATE = "INSERT INTO questions (argument, text, answer1,answer2,answer3) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM questions WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE questions SET argument=?, text=?, answer1=?,answer2=?,answer3=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM question WHERE id=?";
	
	
	public QuestionDAO() {
		
	}
	
	public List<Question> getAll() {
		List<Question> questionsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Question question;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String argument = resultSet.getString("argument");
				String text = resultSet.getString("text");
				String answer1 = resultSet.getString("answer1");
				String answer2 = resultSet.getString("answer2");
				String answer3 = resultSet.getString("answer3");
				
				question = new Question(argument,text, answer1, answer2,answer3);
				question.setId(id);
				questionsList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionsList;
	}
	
	
	public boolean insert(Question questionsToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, questionsToInsert.getArgument());
			preparedStatement.setString(2, questionsToInsert.getText());
			preparedStatement.setString(3, questionsToInsert.getAnswer1());
			preparedStatement.setString(4, questionsToInsert.getAnswer2());
			preparedStatement.setString(5, questionsToInsert.getAnswer3());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public Question read(int questionId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, questionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String argument, text, answer1,answer2,answer3;

			argument = resultSet.getString("argument");
			text = resultSet.getString("text");
			answer1 = resultSet.getString("answer1");
			answer2 = resultSet.getString("answer2");
			answer3 = resultSet.getString("answer3");
			Question question = new Question(argument, text, answer1,answer2,answer3);
			question.setId(resultSet.getInt("id"));

			return question;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Question questionsToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		
		if (questionsToUpdate.getId() == 0)
			return false;

		Question questionRead = read(questionsToUpdate.getId());
		if (!questionRead.equals(questionsToUpdate)) {
			try {
				
				if (questionsToUpdate.getArgument() == null || questionsToUpdate.getArgument().equals("")) {
					questionsToUpdate.setArgument(questionRead.getArgument());
				}

				if (questionsToUpdate.getText() == null || questionsToUpdate.getText().equals("")) {
					questionsToUpdate.setText(questionRead.getText());
				}

				if (questionsToUpdate.getAnswer1() == null || questionsToUpdate.getAnswer1().equals("")) {
					questionsToUpdate.setAnswer1(questionRead.getAnswer1());
				}
				
				if (questionsToUpdate.getAnswer2() == null || questionsToUpdate.getAnswer2().equals("")) {
					questionsToUpdate.setAnswer2(questionRead.getAnswer2());
				}
				
				if (questionsToUpdate.getAnswer3() == null || questionsToUpdate.getAnswer3().equals("")) {
					questionsToUpdate.setAnswer3(questionRead.getAnswer3());
				}
				

				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, questionsToUpdate.getArgument());
				preparedStatement.setString(2, questionsToUpdate.getText());
				preparedStatement.setString(3, questionsToUpdate.getAnswer1());
				preparedStatement.setString(4, questionsToUpdate.getAnswer2());
				preparedStatement.setString(5, questionsToUpdate.getAnswer3());
				preparedStatement.setInt(6, questionsToUpdate.getId());
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
