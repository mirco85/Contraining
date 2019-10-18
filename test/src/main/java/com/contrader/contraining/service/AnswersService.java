package com.contrader.contraining.service;

import com.contrader.contraining.service.dto.AnswersDTO;

import java.util.List;


public interface AnswersService {

    List<AnswersDTO> getQuestionAnswers(Long idQuestion);
    List<AnswersDTO> getUserAnswers(Long idUser);
    List<AnswersDTO> getUserQuestionAnswers(Long idUser, Long idQuestion);

    String getText();

}
