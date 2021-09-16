package br.com.app.modelo.domain.DTO;

import br.com.app.modelo.domain.model.AnoLetivo;
import lombok.Data;

@Data
public class AlunoDTO {
	
	private long idAluno;
	private String nome;
	private String status;
	private AnoLetivo anoLetivo;

}
