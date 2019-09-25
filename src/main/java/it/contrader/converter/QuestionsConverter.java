package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionsDTO;
import it.contrader.model.Questions;

@Component

public class QuestionsConverter extends AbstractConverter<Questions, QuestionsDTO> {
	
	public QuestionsDTO toDTO(Questions questions) {
		QuestionsDTO questionsDTO = null;
		
		
		if (questions != null) {
			questionsDTO = new QuestionsDTO();
			questionsDTO.setId(questions.getId());
			questionsDTO.setText(questions.getText());
		}
		
		return questionsDTO;
	}
	
	
	public Questions toEntity(QuestionsDTO questionsDTO) {
		Questions questions = null;
		
		if (questionsDTO != null) {
			questions = new Questions();
			questions.setId(questionsDTO.getId());
			questions.setText(questionsDTO.getText());
		}
		
		return questions;
	}
	

}
