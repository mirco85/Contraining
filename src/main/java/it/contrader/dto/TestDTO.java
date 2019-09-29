package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDTO {
	
	private Long Id;
	private CategoryDTO category;
	private Long timeTest;
	private String testName;
	private List<QuestionsDTO> questions;
	
	
}