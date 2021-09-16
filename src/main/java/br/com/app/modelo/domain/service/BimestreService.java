package br.com.app.modelo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.app.modelo.domain.DTO.BimestreDTO;
import br.com.app.modelo.domain.model.Bimestre;

public interface BimestreService{

	Page<Bimestre> findAll(Pageable pageable);

	Bimestre findByIdOrThrowBadRequest(long id);

	void delete(long id);

	Bimestre save(BimestreDTO bimestreDTO);

	void update(BimestreDTO bimestreDTO);

}
