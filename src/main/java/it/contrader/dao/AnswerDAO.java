package it.contrader.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Answer;


public class AnswerDAO implements DAO<Answer>
{
	private final String QUERY_ALL = "SELECT * FROM answers";
	private final String QUERY_CREATE = "INSERT INTO answers (iduser, idquestion, answer) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM answers WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE answers SET iduser=?, idquestion=?, answer=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM answers WHERE id=?";

	
	public AnswerDAO() {}
	@Override
	public List<Answer> getAll() {
		List<Answer> answerList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Answer answer;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int iduser = resultSet.getInt("iduser");
				int idquestion = resultSet.getInt("idquestion");
				int answerField = resultSet.getInt("answer");
				
				answer = new Answer(id, iduser, idquestion, answerField);
				answerList.add(answer);				
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return answerList;
	}

	@Override
	public Answer read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement pStatement = connection.prepareStatement(QUERY_READ);
			pStatement.setInt(1,  id);
			ResultSet result = pStatement.executeQuery();
			result.next();
			int idutente, idquestion, answerField, idanswer;
			idutente = result.getInt("iduser");
			idquestion = result.getInt("idquestion");
			answerField = result.getInt("answer");
			idanswer = result.getInt("id");
			
			Answer answer = new Answer(idanswer, idutente, idquestion, answerField);
			return answer;
		} catch(SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean insert(Answer dto) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement pStatement = connection.prepareStatement(QUERY_CREATE);
			pStatement.setInt(1,  dto.getIduser());
			pStatement.setInt(2,  dto.getIdquestion());
			pStatement.setInt(3,  dto.getAnswer());
			pStatement.execute();
			return true;
		} catch(SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean update(Answer dto) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(dto.getId() == 0)
			return false;
		
		Answer answerRead = read(dto.getId());
		if(!answerRead.equals(dto)) {
			try {
				// If not set, use old values
				if(dto.getIdquestion() == 0)
					dto.setIdquestion(answerRead.getIdquestion());
				if(dto.getIduser() == 0)
					dto.setIduser(answerRead.getIduser());
			
				if(dto.getAnswer() == 0)
					dto.setAnswer(answerRead.getAnswer());
				
				
				// Update answer
				PreparedStatement pStatement = connection.prepareStatement(QUERY_UPDATE);
				pStatement.setInt(1,  dto.getIduser());
				pStatement.setInt(2,  dto.getIdquestion());
				pStatement.setInt(3,  dto.getAnswer());
				pStatement.setInt(4, dto.getId());
				
				int updateResult = pStatement.executeUpdate();
				return updateResult > 0;
			} catch(SQLException ex) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement pStatement = connection.prepareStatement(QUERY_DELETE);
			pStatement.setInt(1,  id);
			int deleted = pStatement.executeUpdate();
			return deleted != 0;
		} catch(SQLException ex) {
			return false;
		}
	}
}