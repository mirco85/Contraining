package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.TestConverter;
import it.contrader.converter.TestQuestionConverter;
import it.contrader.dao.TestQuestionRepository;
import it.contrader.dto.TestDTO;
import it.contrader.dto.TestQuestionDTO;
import it.contrader.model.Test;
import it.contrader.model.TestQuestion;

@Service
public class TestQuestionService extends AbstractService<TestQuestion, TestQuestionDTO> {
	@Autowired
	private TestQuestionConverter converter;
	
	@Autowired
	private TestQuestionRepository repository;
	
	
}