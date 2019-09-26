package it.contrader.dto;

import java.util.Set;

import it.contrader.model.QuestionAnswers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class QuestionsDTO {
	
	private Long id;
	
	
	private String text;
	
	
	private Set<QuestionAnswersDTO> questionanswers;

}
