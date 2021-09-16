package br.com.app.modelo.domain.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.modelo.domain.model.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Long>{
	
	List<Aluno> findByNome(String nome);

}
