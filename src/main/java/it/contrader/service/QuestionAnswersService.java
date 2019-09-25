package it.contrader.service;


import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.QuestionAnswersConverter;
import it.contrader.dao.QuestionAnswersRepository;
import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.dto.UserAnswersDTO;
import it.contrader.model.QuestionAnswers;
import it.contrader.model.UserAnswers;

public class QuestionAnswersService extends AbstractService<QuestionAnswers, QuestionAnswersDTO> {
	
	@Autowired
	private QuestionAnswersConverter converter;
	@Autowired
	private QuestionAnswersRepository repository;

}



