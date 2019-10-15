package com.contrader.contraining.service.mapper;

import com.contrader.contraining.domain.*;
import com.contrader.contraining.service.dto.CategoriesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Categories and its DTO CategoriesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategoriesMapper extends EntityMapper<CategoriesDTO, Categories> {



    default Categories fromId(Long id) {
        if (id == null) {
            return null;
        }
        Categories categories = new Categories();
        categories.setId(id);
        return categories;
    }
}
