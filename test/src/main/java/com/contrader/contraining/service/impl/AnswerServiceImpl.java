package com.contrader.contraining.service.impl;

import com.contrader.contraining.service.AnswersService;
import com.contrader.contraining.service.dto.AnswersDTO;
import com.contrader.contraining.web.rest.client.AnswersServiceProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AnswerServiceImpl implements AnswersService {

    private AnswersServiceProxy answersProxy;

    public AnswerServiceImpl(AnswersServiceProxy serviceProxy) {
        this.answersProxy = serviceProxy;
    }


    @Override
    public List<AnswersDTO> getQuestionAnswers(Long idQuestion) {
        return this.answersProxy.getAnswersByQuestion(idQuestion).getBody();
    }

    @Override
    public List<AnswersDTO> getUserAnswers(Long idUser) {
        return this.answersProxy.getAnswersByUser(idUser).getBody();
    }

    @Override
    public List<AnswersDTO> getUserQuestionAnswers(Long idUser, Long idQuestion) {
        return this.answersProxy.getAnswersByUserAndQuestion(idUser, idQuestion).getBody();
    }

    @Override
    public String getText() {
        return answersProxy.getSomeText("Calling Answers From Test! :)").getBody();
    }
}
