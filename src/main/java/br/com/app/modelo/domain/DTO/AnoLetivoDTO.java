package br.com.app.modelo.domain.DTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import br.com.app.modelo.domain.model.Aluno;
import br.com.app.modelo.domain.model.AnoLetivo;
import br.com.app.modelo.domain.model.Bimestre;
import lombok.Data;

@Data
public class AnoLetivoDTO {
	
	private Long idAnoLetivo;
	@NotEmpty(message = "Campo não pode ser nulo")
	private String ano;
	@NotEmpty(message = "Campo não pode ser nulo")
	private AnoLetivo comanda;
	@NotEmpty(message = "Campo não pode ser nulo")
	private List<Bimestre> bimestres;
	private Aluno aluno;
}
