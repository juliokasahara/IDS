package br.com.app.modelo.domain.DTO;

import javax.validation.constraints.NotEmpty;

import br.com.app.modelo.domain.model.AnoLetivo;
import lombok.Data;

@Data
public class AlunoDTO {
	
	private long idAluno;
	@NotEmpty(message = "Campo não pode ser nulo")
	private String nome;
	@NotEmpty(message = "Campo não pode ser nulo")
	private String status;
	@NotEmpty(message = "Campo não pode ser nulo")
	private AnoLetivo anoLetivo;

}
