package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class UserAnswersDTO {
	
	private Long id, idanswer,iduser,idtest,numtest;

	private UserDTO user;
	
	private TestDTO test;
}
