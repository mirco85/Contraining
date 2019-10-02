package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionsDTO;

import it.contrader.model.Questions;
@Component
public class QuestionsConverter extends AbstractConverter<Questions,QuestionsDTO> {

	@Override
	public Questions toEntity(QuestionsDTO questionsdto) {
		Questions questions = null;
	    if(questionsdto != null) {
	    	questions = new Questions(questionsdto.getId(),questionsdto.getText(),questionsdto.getAnswer1(),questionsdto.getAnswer2(),questionsdto.getAnswer3());
	    	
	    	
	    }
		return questions;
	}

	@Override
	public QuestionsDTO toDTO(Questions questions) {
		QuestionsDTO questionsdto = null;
		if (questions != null) {
			questionsdto = new QuestionsDTO(questions.getId(),questions.getText(),questions.getAnswer1(),questions.getAnswer2(),questions.getAnswer3());
			
		}
		return questionsdto;
		
	}
	
	
	
	
	

}
