package it.contrader.service;

import it.contrader.dto.AnswersDTO;
import it.contrader.model.Answer;
import it.contrader.dao.AnswerDAO;
import it.contrader.converter.AnswerConverter;



public class AnswersService extends AbstractService<Answer, AnswersDTO> { 
	
	public AnswersService() {
		this.dao = new AnswerDAO();
		this.converter = new AnswerConverter();
		
	}

}
