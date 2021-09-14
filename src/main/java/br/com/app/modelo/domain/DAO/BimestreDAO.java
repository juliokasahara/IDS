package br.com.app.modelo.domain.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.modelo.domain.model.Bimestre;

public interface BimestreDAO extends JpaRepository<Bimestre, Long>{
	
}
