package br.com.app.modelo.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avaliacao")
	private Long idAvaliacao;
	@Column(nullable = false)
	private BigDecimal nota;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_avaliacao")
	private TipoAvaliacao tipoAvaliacao;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bimestre",referencedColumnName = "id_bimestre")
	private Bimestre bimestre;
	

}
