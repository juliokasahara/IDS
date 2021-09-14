package br.com.app.modelo.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Bimestre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bimestre")
	private Long idBimestre;
	@Column(nullable = false)
	private Integer frequencia;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "bimestre")
	private List<Avaliacao> avaliacoes;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ano_letivo",referencedColumnName = "id_ano_letivo")
	private AnoLetivo anoLetivo;


}
