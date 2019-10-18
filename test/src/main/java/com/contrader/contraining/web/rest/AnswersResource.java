package com.contrader.contraining.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.contrader.contraining.service.AnswersService;
import com.contrader.contraining.service.CategoriesService;
import com.contrader.contraining.service.dto.AnswersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswersResource {

    private final Logger log = LoggerFactory.getLogger(CategoriesResource.class);

    private static final String ENTITY_NAME = "Answers";

    private final AnswersService answersService;

    public AnswersResource(AnswersService service) {
        this.answersService = service;
    }

    @GetMapping("/answers/question{id}")
    @Timed
    public List<AnswersDTO> getAnswersByQuestion(@PathVariable("id") Long idQuestion) {
        return this.answersService.getQuestionAnswers(idQuestion);
    }

    @GetMapping("/answers/user{id}")
    @Timed
    public List<AnswersDTO> getAnswersByUser(@PathVariable("id") Long idUser) {
        return this.answersService.getUserAnswers(idUser);
    }

    @GetMapping("/answers/{idQuestion}and{idUser}")
    @Timed
    public List<AnswersDTO> getAnswersByUserAndQuestion(@PathVariable("idUser") Long idUser, @PathVariable("idQuestion") Long idQuestion) {
        return this.answersService.getUserQuestionAnswers(idUser, idQuestion);
    }
}
