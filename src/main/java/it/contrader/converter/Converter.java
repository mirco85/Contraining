package it.contrader.converter;

import java.util.List;
import java.util.Set;

public interface Converter<Entity, DTO> {

	public Entity toEntity(DTO dto);

	public DTO toDTO(Entity entity);

	public List<DTO> toDTOList(Iterable<Entity> entityList);
	
	public Set<DTO> toDTOSet(Iterable<Entity> entityList);
	
	public Set<Entity> toEntitySet(Iterable<DTO> dtoList);

}