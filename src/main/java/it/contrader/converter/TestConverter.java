package it.contrader.converter;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.model.Category;
import it.contrader.model.Questions;
import it.contrader.model.Test;
import it.contrader.model.UserAnswers;
import it.contrader.dto.CategoryDTO;
import it.contrader.dto.QuestionsDTO;
import it.contrader.dto.TestDTO;
import it.contrader.dto.UserAnswersDTO;


@Component
public class TestConverter extends AbstractConverter<Test, TestDTO> {

	private static QuestionsConverter questionConverter = new QuestionsConverter();
	private static CategoryConverter categoryConverter = new CategoryConverter();
	
	
	@Override
	public Test toEntity(TestDTO testDTO) {
		Test test = null;
		if (testDTO != null) {
			List<Questions> questions = questionConverter.toEntityList(testDTO.getQuestions());
			Category c = categoryConverter.toEntity(testDTO.getCategory());
			test = new Test(testDTO.getId(), c, testDTO.getTimeTest(), testDTO.getTestName(), questions);
		}
		return test;
	}

	@Override
	public TestDTO toDTO(Test test) {
		TestDTO testDTO = null;
		if (test != null) {
			List<QuestionsDTO> questions = questionConverter.toDTOList(test.getQuestions());
			CategoryDTO c = categoryConverter.toDTO(test.getCategory());
			testDTO = new TestDTO(test.getId(), c, test.getTimeTest(), test.getTestName(), questions);

		}
		return testDTO;
	}
}