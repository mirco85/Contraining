package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestQuestionDTO {
	
	private Long id;
	private Long idTest;
	private Long idUser;
}
