package com.contrader.contraining.web.rest.client;

import com.contrader.contraining.service.dto.AnswersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "answer")
public interface AnswersServiceProxy {

    @RequestMapping(value = "/api/answersByQuestion/{id}")
    ResponseEntity<List<AnswersDTO>> getAnswersByQuestion(@PathVariable("id") Long idQuestion);

    @RequestMapping(value = "/api/answersByUser/{id}")
    ResponseEntity<List<AnswersDTO>> getAnswersByUser(@PathVariable(value = "id") Long id);

    @RequestMapping(value = "/api/answersByUserAndQuestion/{idUser}and{idQuestion}")
    ResponseEntity<List<AnswersDTO>> getAnswersByUserAndQuestion(@PathVariable(value = "idUser") Long idUser,  @PathVariable(value="idQuestion") Long idQuestion);

    @RequestMapping(value = "/api/sometext/{varText}")
    ResponseEntity<String> getSomeText(@PathVariable("varText") String text);

}
