package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.QuestionsRepository;
import it.contrader.dto.QuestionsDTO;
import it.contrader.model.Questions;

@Service
public class QuestionsService extends AbstractService<Questions,QuestionsDTO>{
	
	public List<QuestionsDTO> getAllAvailable() {
		return this.converter.toDTOList(((QuestionsRepository)this.repository).getAllAvailable());
	}
}
