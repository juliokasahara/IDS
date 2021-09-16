package br.com.app.modelo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.modelo.domain.DAO.AnoLetivoDAO;
import br.com.app.modelo.domain.DTO.AnoLetivoDTO;
import br.com.app.modelo.domain.exception.BadRequestException;
import br.com.app.modelo.domain.mapper.AnoLetivoMapper;
import br.com.app.modelo.domain.model.AnoLetivo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnoLetivoServiceImpl implements AnoLetivoService{
	
	private final AnoLetivoDAO anoLetivoDAO;

	public Page<AnoLetivo> findAll(Pageable pageable) {
		return anoLetivoDAO.findAll(pageable);
	}

	public AnoLetivo findByIdOrThrowBadRequest(long id) {
		return anoLetivoDAO.findById(id).orElseThrow(() -> new BadRequestException("Usuario não existe"));
	}

	public void delete(long id) {
		anoLetivoDAO.delete(findByIdOrThrowBadRequest(id));
	}
	
	@Transactional(rollbackFor = Exception.class)
	public AnoLetivo save(AnoLetivoDTO anoLetivoDTO) {
		
		return anoLetivoDAO.save(AnoLetivoMapper.INSTANCE.toAnoLetivo(anoLetivoDTO));
	}

	public void update(AnoLetivoDTO anoLetivoDTO) {
		AnoLetivo anoLetivoBanco = findByIdOrThrowBadRequest(anoLetivoDTO.getIdAnoLetivo());
		AnoLetivo anoLetivo = AnoLetivoMapper.INSTANCE.toAnoLetivo(anoLetivoDTO);
		anoLetivo.setIdAnoLetivo(anoLetivoBanco.getIdAnoLetivo());
		anoLetivoDAO.save(anoLetivo);
	}

}
