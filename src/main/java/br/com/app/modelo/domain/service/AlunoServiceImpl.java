package br.com.app.modelo.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.app.modelo.domain.DAO.AlunoDAO;
import br.com.app.modelo.domain.DTO.AlunoDTO;
import br.com.app.modelo.domain.constant.Constants;
import br.com.app.modelo.domain.exception.BadRequestException;
import br.com.app.modelo.domain.mapper.AlunoMapper;
import br.com.app.modelo.domain.model.Aluno;
import br.com.app.modelo.domain.model.Avaliacao;
import br.com.app.modelo.domain.model.Bimestre;
import br.com.app.modelo.domain.util.Util;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService{
	
	private final AlunoDAO alunoDAO;

	public Page<Aluno> findAll(Pageable pageable) {
		
		Page<Aluno> alunos = alunoDAO.findAll(pageable);
		for (Aluno aluno : alunos) {
			calcularAno(aluno);		
		}
		
		return alunos;
	}

	public List<Aluno> findByName(String nome) {
		return alunoDAO.findByNome(nome);
	}

	public Aluno findByIdOrThrowBadRequest(long id) {
		return calcularAno(alunoDAO.findById(id).orElseThrow(() -> new BadRequestException("Usuario não existe")));
	}

	public void delete(long id) {
		alunoDAO.delete(findByIdOrThrowBadRequest(id));
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Aluno save(AlunoDTO alunoDTO) {
		
		return alunoDAO.save(AlunoMapper.INSTANCE.toAluno(alunoDTO));
	}

	public void update(AlunoDTO alunoDTO) {
		Aluno alunoBanco = findByIdOrThrowBadRequest(alunoDTO.getIdAluno());
		Aluno aluno = AlunoMapper.INSTANCE.toAluno(alunoDTO);
		aluno.setIdAluno(alunoBanco.getIdAluno());
		alunoDAO.save(aluno);
	}
	
	
	private Aluno calcularAno(Aluno aluno) {
			BigDecimal totalNota = new BigDecimal(0);
			Integer totalFrequencia = 0;
			if(aluno.getAnoLetivo() != null){
				if(!CollectionUtils.isEmpty(aluno.getAnoLetivo().getBimestres())) {
					for (Bimestre bimestre : aluno.getAnoLetivo().getBimestres()) {
						
						totalFrequencia += bimestre.getFrequencia();
						
						if(!CollectionUtils.isEmpty(bimestre.getAvaliacoes())) {
							for (Avaliacao avaliacao : bimestre.getAvaliacoes()) {
								totalNota = totalNota.add(avaliacao.getNota());
							}
						}
					}
					
					BigDecimal qntBimestre = new BigDecimal(aluno.getAnoLetivo().getBimestres().size());
					BigDecimal mediaFinal = totalNota.divide(qntBimestre);
					BigDecimal frequenciaBimestre = new BigDecimal(Constants.NUM_FREQUENCIA_AULA).multiply(qntBimestre);
					BigDecimal porcentFrequencia = Util.regraTres(new BigDecimal(totalFrequencia), Constants.PORCENT_CEM, frequenciaBimestre);
					
					aluno.getAnoLetivo().setTotalNota(totalNota);
					aluno.getAnoLetivo().setTotalFrequencia(frequenciaBimestre);
					aluno.getAnoLetivo().setStatusAnoLetivo(calcular(totalFrequencia,mediaFinal,qntBimestre,porcentFrequencia));
					aluno.getAnoLetivo().setMediaNota(mediaFinal);
					aluno.getAnoLetivo().setPorcFrequencia(porcentFrequencia);
					aluno.getAnoLetivo().setFrequencia(totalFrequencia);
				}
			}
		return aluno;
	}

	private String calcular(Integer totalFrequencia, BigDecimal mediaFinal,BigDecimal qntBimestre,BigDecimal porcentFrequencia) {
		
		StringBuilder desStatus = new StringBuilder();
		

		
		if(Constants.PORCENT_FREQUENCIA.compareTo(porcentFrequencia) == 1) {
			desStatus.append(Constants.REP_FREQUENCIA);
		}else {
			if(Constants.NOTA_REPROVACAO.compareTo(mediaFinal) == 1 ) {
				desStatus.append(Constants.REP_NOTA);
				
			}else if(Constants.NOTA_RECUPERACAO.compareTo(mediaFinal) == 1) {
				desStatus.append(Constants.RECUPERACAO);
				
			}else {
				if(Constants.PORCENT_FREQUENCIA.compareTo(porcentFrequencia) == 1) {
					desStatus.append(Constants.REP_FREQUENCIA);
				}else {
					desStatus.append(Constants.APROVADO);
				}
			}
		}
		return desStatus.toString();
	}

}
