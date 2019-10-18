package com.contrader.contraining.service.impl;

import com.contrader.contraining.service.AnswersService;
import com.contrader.contraining.web.rest.client.AnswersServiceProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AnswerServiceImpl implements AnswersService {

    private AnswersServiceProxy answersProxy;

    public AnswerServiceImpl(AnswersServiceProxy serviceProxy) {
        this.answersProxy = serviceProxy;
    }

    @Override
    public String getText() {
        return answersProxy.getSomeText("Calling Answers From Test! :)").getBody();
    }
}
