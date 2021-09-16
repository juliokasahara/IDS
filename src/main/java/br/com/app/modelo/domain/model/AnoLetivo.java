package br.com.app.modelo.domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "ano_letivo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AnoLetivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ano_letivo")
	private Long idAnoLetivo;
	@Column(nullable = false)
	private String ano;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	private List<Bimestre> bimestres;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "anoLetivo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Aluno aluno;

	@Transient
	private String statusAnoLetivo;	
	@Transient
	private Integer frequencia;
	@Transient
	private BigDecimal porcFrequencia;
	@Transient
	private BigDecimal totalFrequencia;
	@Transient
	private BigDecimal totalNota;
	@Transient
	private BigDecimal MediaNota;


}
