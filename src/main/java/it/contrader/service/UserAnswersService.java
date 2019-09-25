package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.UserAnswersConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.UserAnswerRepository;
import it.contrader.dto.UserAnswersDTO;

import it.contrader.model.UserAnswers;

@Service
public class UserAnswersService extends AbstractService<UserAnswers, UserAnswersDTO> {
	
	
	@Autowired
	private UserAnswersConverter converter;
	@Autowired
	private UserAnswerRepository repository;

	

}
