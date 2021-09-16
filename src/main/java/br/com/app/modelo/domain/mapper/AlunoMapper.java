package br.com.app.modelo.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.modelo.domain.DTO.AlunoDTO;
import br.com.app.modelo.domain.model.Aluno;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {	
	public static final AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);
	
	public abstract Aluno toAluno(AlunoDTO alunoDTO);
	
}