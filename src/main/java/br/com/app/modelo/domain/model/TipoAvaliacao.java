package br.com.app.modelo.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data para gerar o get/set e EqualsAndHashCode

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoAvaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_avaliacao")
	private Long idTipoAvaliacao;
	@Column(nullable = false)
	private String atividade;
	@Column(nullable = false)
	private BigDecimal notaMaxima;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "tipoAvaliacao")
	private Avaliacao avaliacao;
	

}
