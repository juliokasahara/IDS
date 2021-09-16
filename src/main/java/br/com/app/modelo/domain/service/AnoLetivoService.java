package br.com.app.modelo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.app.modelo.domain.DTO.AnoLetivoDTO;
import br.com.app.modelo.domain.model.AnoLetivo;

public interface AnoLetivoService{

	Page<AnoLetivo> findAll(Pageable pageable);

	AnoLetivo findByIdOrThrowBadRequest(long id);

	void delete(long id);

	AnoLetivo save(AnoLetivoDTO anoLetivoDTO);

	void update(AnoLetivoDTO anoLetivoDTO);

}
