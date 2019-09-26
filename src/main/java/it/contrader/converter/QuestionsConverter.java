package it.contrader.converter;

import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.dto.QuestionsDTO;
import it.contrader.model.QuestionAnswers;
import it.contrader.model.Questions;

@Component

public class QuestionsConverter extends AbstractConverter<Questions, QuestionsDTO> {
	private static QuestionAnswersConverter questionAnswersConverter = new QuestionAnswersConverter();
	
	public QuestionsDTO toDTO(Questions questions) {
		QuestionsDTO questionsDTO = null;
		
		
		if (questions != null) {
			questionsDTO = new QuestionsDTO();
			questionsDTO.setId(questions.getId());
			questionsDTO.setText(questions.getText());
			Set<QuestionAnswersDTO> answers = questionAnswersConverter.toDTOSet(questions.getQuestionanswers());
			questionsDTO.setQuestionanswers(answers);
		}
		
		return questionsDTO;
	}
	
	
	public Questions toEntity(QuestionsDTO questionsDTO) {
		Questions questions = null;
		
		if (questionsDTO != null) {
			questions = new Questions();
			questions.setId(questionsDTO.getId());
			questions.setText(questionsDTO.getText());
			Set<QuestionAnswers> answers = questionAnswersConverter.toEntitySet(questionsDTO.getQuestionanswers());
			questions.setQuestionanswers(answers);
		}
		
		return questions;
	}
	

}
