package com.contrader.contraining.service.mapper;

import com.contrader.contraining.domain.*;
import com.contrader.contraining.service.dto.QuestionsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Questions and its DTO QuestionsDTO.
 */
@Mapper(componentModel = "spring", uses = {TestsMapper.class})
public interface QuestionsMapper extends EntityMapper<QuestionsDTO, Questions> {

    @Mapping(source = "tests.id", target = "testsId")
    @Mapping(source = "tests.testName", target = "testsTestName")
    QuestionsDTO toDto(Questions questions);

    @Mapping(source = "testsId", target = "tests")
    Questions toEntity(QuestionsDTO questionsDTO);

    default Questions fromId(Long id) {
        if (id == null) {
            return null;
        }
        Questions questions = new Questions();
        questions.setId(id);
        return questions;
    }
}
