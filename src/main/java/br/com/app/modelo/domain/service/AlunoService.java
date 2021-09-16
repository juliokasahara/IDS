package br.com.app.modelo.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.app.modelo.domain.DTO.AlunoDTO;
import br.com.app.modelo.domain.model.Aluno;

public interface AlunoService{

	Page<Aluno> findAll(Pageable pageable);
	
	List<Aluno> findByName(String nome);

	Aluno findByIdOrThrowBadRequest(long id);

	void delete(long id);

	Aluno save(AlunoDTO alunoDTO);

	void update(AlunoDTO alunoDTO);
	
	void matricular(AlunoDTO alunoDTO);

}
