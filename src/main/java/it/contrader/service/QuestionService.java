package it.contrader.service;

import java.util.List;

import it.contrader.converter.QuestionConverter;
import it.contrader.dao.QuestionDAO;
import it.contrader.dto.QuestionDTO;

public class QuestionService {
	
	private QuestionDAO questionDAO;
	private QuestionConverter questionConverter;


	public QuestionService() {
	this.questionDAO = new QuestionDAO();
	this.questionConverter = new QuestionConverter();
}

	public List<QuestionDTO> getAll(){
		return this.questionConverter.toDTOList(this.questionDAO.getAll());
		}
	
	
	 public QuestionDTO read( int questionid) {
		 return this.questionConverter.toDTO(this.questionDAO.read(questionid));
		  }
	
	 public boolean delete( int questionid) {
		 return questionDAO.delete(questionid);
	 }
	public boolean insert(QuestionDTO questionDTO) {
		return questionDAO.insert(questionConverter.toEntity(questionDTO));
		
	}
	
	public boolean update(QuestionDTO questionDTO) {
		return questionDAO.update(questionConverter.toEntity(questionDTO));
		
	}
}
