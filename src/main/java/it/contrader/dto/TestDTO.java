package it.contrader.dto;

import java.util.Set;

import it.contrader.model.UserAnswers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDTO {
	
	private Long Id;
	private Long idCategory;
	private Long timeTest;
	private Set<UserAnswersDTO> answers;
	
	
}