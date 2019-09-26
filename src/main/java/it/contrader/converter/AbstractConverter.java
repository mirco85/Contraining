package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractConverter<Entity, DTO> implements Converter<Entity, DTO> {
	
	public List<Entity> toEntityList(List<DTO> listDTO) {
		List<Entity> list = new ArrayList<Entity>();
		
		if (listDTO != null) {
			for (DTO dto : listDTO) {
				Entity entity = toEntity(dto);
				list.add(entity);
			}
		}
		return list;
	}

	public List<DTO> toDTOList(Iterable<Entity> listEntity) {

		List<DTO> list = new ArrayList<DTO>();

		if (listEntity != null) {
			for (Entity entity : listEntity) {
				DTO dto = toDTO(entity);
				list.add(dto);
			}
		}
		return list;
	}

	public Set<DTO> toDTOSet(Iterable<Entity> entityList) {
		if(entityList == null)
			return null;
		
		Iterator<Entity> data = entityList.iterator();
		Set<DTO> dtos = new HashSet<>();
		while(data.hasNext()) {
			Entity e = data.next();
			dtos.add(toDTO(e));
		}
		
		return dtos;
	}

	public Set<Entity> toEntitySet(Iterable<DTO> dtoList) {
		if(dtoList == null)
			return null;
		
		Iterator<DTO> data = dtoList.iterator();
		Set<Entity> entities = new HashSet<>();
		while(data.hasNext()) {
			DTO e = data.next();
			entities.add(toEntity(e));
		}
		
		return entities;
	}
}
