package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.contrader.model.Question;
import it.contrader.utils.ConnectionSingleton;

public class QuestionDAO implements DAO<Question>{
	
	
	private final String QUERY_ALL = "select questions.id,argument,idargument,text,answer1,answer2,answer3,questiontime from Questions JOIN Category on questions.idargument=category.id";
	private final String QUERY_CREATE = "INSERT INTO questions (idargument, text, answer1,answer2,answer3,questiontime) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ =  "SELECT questions.id,argument,idargument,text,answer1,answer2,answer3,questiontime FROM Questions JOIN Category on questions.idargument=category.id WHERE questions.id=?";
	private final String QUERY_UPDATE = "UPDATE questions SET idargument=?, text=?, answer1=?,answer2=?,answer3=?,questiontime=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM questions WHERE id=?";
	private final String QUERY_BY_CATEGORY = "select questions.id,argument,idargument,text,answer1,answer2,answer3,questiontime from Questions JOIN Category on questions.idargument=category.id where category.id=?";
	
	
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
				int idargument = resultSet.getInt("idargument");
				String text = resultSet.getString("text");
				String answer1 = resultSet.getString("answer1");
				String answer2 = resultSet.getString("answer2");
				String answer3 = resultSet.getString("answer3");
				int questiontime = resultSet.getInt("questiontime");
				
				question = new Question(idargument,text, answer1, answer2,answer3,questiontime);
				question.setId(id);
				question.setArgument(argument);
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
			preparedStatement.setInt(1, questionsToInsert.getIdargument());
			preparedStatement.setString(2, questionsToInsert.getText());
			preparedStatement.setString(3, questionsToInsert.getAnswer1());
			preparedStatement.setString(4, questionsToInsert.getAnswer2());
			preparedStatement.setString(5, questionsToInsert.getAnswer3());
			preparedStatement.setInt(6, questionsToInsert.getQuestiontime());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	private List<Question> chooseRandomQuestions(List<Question> questions) {
		// If questions are less than 20, choose all questions
		if(questions.size() < 20) {
			return questions;
		}
		
		List<Question> result = new ArrayList();
		Random qRandom = new Random();
		int pos;
		for(int i = 0; i < 20; i++) {
			pos = (int)(qRandom.nextDouble() * questions.size());
			result.add(questions.get(pos));
			questions.remove(pos);
		}
		return result;
	}
	
	public List<Question> getByCategory(int categoryID) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_CATEGORY);
			preparedStatement.setInt(1,  categoryID);
			ResultSet results = preparedStatement.executeQuery();
			List<Question> questions = new ArrayList();
			String argument, text, a1,a2,a3;
			int id, questionTime;
			while(results.next()) {
				id = results.getInt("id");
				questionTime = results.getInt("questionTime");
				argument = results.getString("argument");
				text = results.getString("text");
				a1 = results.getString("answer1");
				a2 = results.getString("answer2");
				a3 = results.getString("answer3");
				
				Question q = new Question(id, categoryID, text, a1, a2, a3, questionTime);
				q.setArgument(argument);
				questions.add(q);
			}
			return chooseRandomQuestions(questions);
		}  catch(SQLException ex) {
			return null;
		}
		
		
	}
	
	public Question read(int questionId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, questionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String argument,text, answer1,answer2,answer3;
            
			int idargument,questiontime;

			argument = resultSet.getString("argument");
			idargument = resultSet.getInt("idargument");
			text = resultSet.getString("text");
			answer1 = resultSet.getString("answer1");
			answer2 = resultSet.getString("answer2");
			answer3 = resultSet.getString("answer3");
			questiontime = resultSet.getInt("questiontime");
			Question question = new Question(idargument,text, answer1,answer2,answer3,questiontime);
			question.setId(resultSet.getInt("id"));
			question.setArgument(argument);
			
			
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
				
				if (questionsToUpdate.getIdargument() == 0) {
					questionsToUpdate.setIdargument(questionRead.getIdargument());
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
				
				if (questionsToUpdate.getQuestiontime() == 0) {
					questionsToUpdate.setQuestiontime(questionRead.getQuestiontime());
				}

				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, questionsToUpdate.getIdargument());
				preparedStatement.setString(2, questionsToUpdate.getText());
				preparedStatement.setString(3, questionsToUpdate.getAnswer1());
				preparedStatement.setString(4, questionsToUpdate.getAnswer2());
				preparedStatement.setString(5, questionsToUpdate.getAnswer3());
				preparedStatement.setInt(6, questionsToUpdate.getQuestiontime());
				preparedStatement.setInt(7, questionsToUpdate.getId());
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
