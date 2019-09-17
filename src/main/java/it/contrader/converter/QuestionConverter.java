package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.QuestionDTO;

import it.contrader.model.Question;


public class QuestionConverter  {
	
	
	
	public QuestionDTO toDTO(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();
		if (question != null) {
			questionDTO.setId(question.getId());
			questionDTO.setArgument(question.getArgument());
			questionDTO.setText(question.getText());
			questionDTO.setAnswer1(question.getAnswer1());
			questionDTO.setAnswer2(question.getAnswer2());
			questionDTO.setAnswer3(question.getAnswer3());
			
			
		}
		return questionDTO;	
	}		
	
	
	public Question toEntity(QuestionDTO questionDTO) {
		Question question = new Question();
		if (questionDTO != null) {
			question.setId(questionDTO.getId());
			question.setArgument(questionDTO.getArgument());
			question.setText(questionDTO.getText());
			question.setAnswer1(questionDTO.getAnswer1());
			question.setAnswer2(questionDTO.getAnswer2());
			question.setAnswer3(questionDTO.getAnswer3());
		}
		return question;
	}
	
	public List<QuestionDTO> toDTOList(List<Question> questionsList) {
		// Crea una lista vuota.
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Question question : questionsList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			questionDTOList.add(toDTO(question));
		}
		return questionDTOList;
	}
}
