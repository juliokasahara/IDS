package br.com.app.modelo.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.modelo.domain.DTO.BimestreDTO;
import br.com.app.modelo.domain.model.Bimestre;

@Mapper(componentModel = "spring")
public abstract class BimestreMapper {	
	public static final BimestreMapper INSTANCE = Mappers.getMapper(BimestreMapper.class);
	
	public abstract Bimestre toBimestre(BimestreDTO bimestreDTO);
	
}