package br.com.app.modelo.domain.DTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import br.com.app.modelo.domain.model.Avaliacao;
import lombok.Data;

@Data
public class BimestreDTO {
	
	private Long idBimestre;
	@NotEmpty(message = "Campo não pode ser nulo")
	private Integer frequencia;
	private List<Avaliacao> avaliacoes;

}
