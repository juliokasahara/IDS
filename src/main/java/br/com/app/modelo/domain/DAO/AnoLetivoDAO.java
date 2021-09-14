package br.com.app.modelo.domain.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.modelo.domain.model.AnoLetivo;

public interface AnoLetivoDAO extends JpaRepository<AnoLetivo, Long>{
	
	
}
