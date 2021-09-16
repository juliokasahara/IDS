package br.com.app.modelo.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.modelo.domain.DTO.AnoLetivoDTO;
import br.com.app.modelo.domain.model.AnoLetivo;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public abstract class AnoLetivoMapper {	
	public static final AnoLetivoMapper INSTANCE = Mappers.getMapper(AnoLetivoMapper.class);
	
	@Mapping(target = "MediaNota", ignore = true)
	@Mapping(target = "frequencia", ignore = true)
	@Mapping(target = "porcFrequencia", ignore = true)
	@Mapping(target = "statusAnoLetivo", ignore = true)
	@Mapping(target = "totalFrequencia", ignore = true)
	@Mapping(target = "totalNota", ignore = true)
	public abstract AnoLetivo toAnoLetivo(AnoLetivoDTO AnoLetivoDTO);
	
}
