package it.contrader.converter;

import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.dto.QuestionsDTO;
import it.contrader.model.QuestionAnswers;
import it.contrader.model.Questions;

@Component
public class QuestionAnswersConverter extends AbstractConverter<QuestionAnswers, QuestionAnswersDTO> {
	
	private static QuestionsConverter questionsConverter = new QuestionsConverter();
	
	@Override
	public QuestionAnswersDTO toDTO(QuestionAnswers questionanswers) {
		QuestionAnswersDTO questionanswersDTO = null;
		
		
		if (questionanswers != null) {
			questionanswersDTO = new QuestionAnswersDTO();
			questionanswersDTO.setId(questionanswers.getId());
			questionanswersDTO.setText(questionanswers.getText());
			questionanswersDTO.setIdquestion(questionanswers.getIdquestion());
			questionanswersDTO.setRightAnswer(questionanswers.getRightAnswer());
			QuestionsDTO question = questionsConverter.toDTO(questionanswers.getQuestion());
			questionanswersDTO.setQuestion(question);
		}
		
		return questionanswersDTO;
	}
	
	@Override
	public QuestionAnswers toEntity(QuestionAnswersDTO questionanswersDTO) {
		QuestionAnswers questionanswers = null;
		
		if (questionanswersDTO != null) {
			questionanswers = new QuestionAnswers();
			questionanswers.setId(questionanswersDTO.getId());
			questionanswers.setText(questionanswersDTO.getText());
			questionanswersDTO.setIdquestion(questionanswers.getIdquestion());
			questionanswersDTO.setRightAnswer(questionanswers.getRightAnswer());
			Questions question = questionsConverter.toEntity(questionanswersDTO.getQuestion());
			questionanswers.setQuestion(question);
		}
		
		return questionanswers;
	}
	

}
