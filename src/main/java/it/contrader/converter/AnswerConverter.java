package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AnswersDTO;
import it.contrader.model.Answer;


public class AnswerConverter implements Converter<Answer, AnswersDTO> {

	
	public AnswersDTO toDTO(Answer answer) {
		AnswersDTO AnswersDTO = new AnswersDTO();
		 if (answer!=null) {
			 AnswersDTO.setId(answer.getId());
			 AnswersDTO.setIduser(answer.getIduser());
			 AnswersDTO.setIdquestion(answer.getIdquestion());
			 AnswersDTO.setAnswer(answer.getAnswer());
		 }
		 return AnswersDTO;
		 
			 
	}
	
	public Answer toEntity(AnswersDTO AnswersDTO) {
		Answer answer= new Answer();
		if (AnswersDTO !=null) {
			answer.setId(AnswersDTO.getId());
			answer.setIduser(AnswersDTO.getIduser());
			answer.setIdquestion(AnswersDTO.getIdquestion());
			answer.setAnswer(AnswersDTO.getAnswer());
		}
		return answer;
	}
	
	public List<AnswersDTO> toDTOList(List<Answer> answerList) {
		
		List<AnswersDTO> answerDTOList = new ArrayList<AnswersDTO>();
		
		for (Answer answers : answerList) {
			
			answerDTOList.add(toDTO(answers));
			
		}
		return answerDTOList; 
	}
	
}
