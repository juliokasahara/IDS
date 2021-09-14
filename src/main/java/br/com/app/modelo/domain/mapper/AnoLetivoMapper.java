package br.com.app.modelo.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.modelo.domain.DTO.AnoLetivoDTO;
import br.com.app.modelo.domain.model.AnoLetivo;


@Mapper(componentModel = "spring")
public abstract class AnoLetivoMapper {	
	public static final AnoLetivoMapper INSTANCE = Mappers.getMapper(AnoLetivoMapper.class);
	
	public abstract AnoLetivo toProduto(AnoLetivoDTO AnoLetivoDTO);
	
}
