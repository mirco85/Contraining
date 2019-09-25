package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionAnswersDTO;
import it.contrader.model.QuestionAnswers;

@Component
public class QuestionAnswersConverter extends AbstractConverter<QuestionAnswers, QuestionAnswersDTO> {
	
	@Override
	public QuestionAnswersDTO toDTO(QuestionAnswers questionanswers) {
		QuestionAnswersDTO questionanswersDTO = null;
		
		
		if (questionanswers != null) {
			questionanswersDTO = new QuestionAnswersDTO();
			questionanswersDTO.setId(questionanswers.getId());
			questionanswersDTO.setText(questionanswers.getText());
			questionanswersDTO.setIdquestion(questionanswers.getIdquestion());
			questionanswersDTO.setRight(questionanswers.getRight());
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
			questionanswersDTO.setRight(questionanswers.getRight());
		}
		
		return questionanswers;
	}
	

}
