package br.com.app.modelo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.modelo.domain.DAO.BimestreDAO;
import br.com.app.modelo.domain.DTO.BimestreDTO;
import br.com.app.modelo.domain.exception.BadRequestException;
import br.com.app.modelo.domain.mapper.BimestreMapper;
import br.com.app.modelo.domain.model.Bimestre;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BimestreServiceImpl implements BimestreService{
	
	private final BimestreDAO bimestreDAO;

	public Page<Bimestre> findAll(Pageable pageable) {
			
		return bimestreDAO.findAll(pageable);
	}

	public Bimestre findByIdOrThrowBadRequest(long id) {
		return bimestreDAO.findById(id).orElseThrow(() -> new BadRequestException("Usuario não existe"));
	}

	public void delete(long id) {
		bimestreDAO.delete(findByIdOrThrowBadRequest(id));
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Bimestre save(BimestreDTO bimestreDTO) {
		
		return bimestreDAO.save(BimestreMapper.INSTANCE.toBimestre(bimestreDTO));
	}

	public void update(BimestreDTO bimestreDTO) {
		Bimestre bimestreBanco = findByIdOrThrowBadRequest(bimestreDTO.getIdBimestre());
		Bimestre bimestre = BimestreMapper.INSTANCE.toBimestre(bimestreDTO);
		bimestre.setIdBimestre(bimestreBanco.getIdBimestre());
		bimestreDAO.save(bimestre);
	}

}
