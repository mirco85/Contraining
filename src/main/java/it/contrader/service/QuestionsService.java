package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.QuestionsConverter;
import it.contrader.dao.QuestionsRepository;
import it.contrader.dto.QuestionsDTO;
import it.contrader.model.Questions;

@Service

public class QuestionsService extends AbstractService<Questions, QuestionsDTO> {
	
	@Autowired
	private QuestionsRepository questionsRepository;
	
	
	@Autowired
	private QuestionsConverter questionsConverter;
	
	public List<QuestionsDTO> findAllQuestions() {
		
		return questionsConverter.toDTOList(questionsRepository.findAll());
	}

}
