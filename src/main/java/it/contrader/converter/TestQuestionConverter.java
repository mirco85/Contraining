package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.model.TestQuestion;
import it.contrader.dto.TestQuestionDTO;

@Component
public class TestQuestionConverter extends AbstractConverter<TestQuestion, TestQuestionDTO> {

	@Override
	public TestQuestion toEntity(TestQuestionDTO testQuestionDTO) {
		TestQuestion testQuestion = null;
		if(testQuestionDTO != null) 
			testQuestion = new TestQuestion(testQuestionDTO.getId(), testQuestionDTO.getIdUser(), testQuestionDTO.getIdTest());
		
		return testQuestion;
	}
	

	@Override
	public TestQuestionDTO toDTO(TestQuestion testQuestion) {
		TestQuestionDTO testQuestionDTO = null;
		if(testQuestionDTO != null)
			testQuestionDTO = new TestQuestionDTO(testQuestion.getId(), testQuestion.getIdUser(), testQuestion.getIdUser());
		
		return testQuestionDTO;
	}
}