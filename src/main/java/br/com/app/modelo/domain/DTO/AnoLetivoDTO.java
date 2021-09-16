package br.com.app.modelo.domain.DTO;

import java.util.List;

import br.com.app.modelo.domain.model.Aluno;
import br.com.app.modelo.domain.model.Bimestre;
import lombok.Data;

@Data
public class AnoLetivoDTO {
	
	private Long idAnoLetivo;
	private String ano;
	private List<Bimestre> bimestres;
	private Aluno aluno;
}
