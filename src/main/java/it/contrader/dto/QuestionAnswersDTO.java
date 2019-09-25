package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuestionAnswersDTO {
	
	private Long id;
	private String text;
	private Long  idquestion;
	private Boolean right;


}
