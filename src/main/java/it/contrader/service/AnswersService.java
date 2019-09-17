package it.contrader.service;

import it.contrader.dto.AnswersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Answer;
import it.contrader.dao.AnswerDAO;

import java.util.List;

import it.contrader.converter.AnswerConverter;



public class AnswersService { 
	private AnswerDAO dao;
	private AnswerConverter converter;
	
	public AnswersService() {
		this.dao = new AnswerDAO();
		this.converter = new AnswerConverter();
		
	}
	public List<AnswersDTO> getAll() {
		return this.converter.toDTOList(this.dao.getAll());
	}

	public AnswersDTO read(int id) {
		return this.converter.toDTO(this.dao.read(id));
	}

	public boolean delete(int answerId) {
		return dao.delete(answerId);
	}
	public boolean insert(AnswersDTO answerDTO) {
		return dao.insert(converter.toEntity(answerDTO));
	}
	public boolean update(AnswersDTO answerDTO) {
		return dao.update(converter.toEntity(answerDTO));
	}
}
