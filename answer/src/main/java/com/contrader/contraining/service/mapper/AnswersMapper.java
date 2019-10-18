package com.contrader.contraining.service.mapper;

import com.contrader.contraining.domain.*;
import com.contrader.contraining.service.dto.AnswersDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Answers and its DTO AnswersDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AnswersMapper extends EntityMapper<AnswersDTO, Answers> {



    default Answers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Answers answers = new Answers();
        answers.setId(id);
        return answers;
    }
}
