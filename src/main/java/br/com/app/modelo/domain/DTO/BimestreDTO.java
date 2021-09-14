package br.com.app.modelo.domain.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import br.com.app.modelo.domain.model.AnoLetivo;
import lombok.Data;

@Data
public class BimestreDTO {
	
	private Long idBimestre;
	@NotEmpty(message = "Campo não pode ser nulo")
	private BigDecimal nota;
	@NotEmpty(message = "Campo não pode ser nulo")
	private Integer frequencia;
	@NotEmpty(message = "Campo não pode ser nulo")
	private AnoLetivo anoLetivo;

}
