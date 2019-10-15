package com.contrader.contraining.service.mapper;

import com.contrader.contraining.domain.*;
import com.contrader.contraining.service.dto.TestsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tests and its DTO TestsDTO.
 */
@Mapper(componentModel = "spring", uses = {CategoriesMapper.class})
public interface TestsMapper extends EntityMapper<TestsDTO, Tests> {

    @Mapping(source = "categories.id", target = "categoriesId")
    @Mapping(source = "categories.category", target = "categoriesCategory")
    TestsDTO toDto(Tests tests);

    @Mapping(source = "categoriesId", target = "categories")
    @Mapping(target = "questions", ignore = true)
    Tests toEntity(TestsDTO testsDTO);

    default Tests fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tests tests = new Tests();
        tests.setId(id);
        return tests;
    }
}
