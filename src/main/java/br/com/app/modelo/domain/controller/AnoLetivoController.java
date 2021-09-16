package br.com.app.modelo.domain.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.modelo.domain.DTO.AnoLetivoDTO;
import br.com.app.modelo.domain.model.AnoLetivo;
import br.com.app.modelo.domain.service.AnoLetivoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("ano-letivo")
public class AnoLetivoController {
	
	private final AnoLetivoService anoLetivoService;
	
	@GetMapping
	public ResponseEntity<Page<AnoLetivo>> list(Pageable pageable) {
		return ResponseEntity.ok(anoLetivoService.findAll(pageable));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<AnoLetivo> findById(@PathVariable long id) {
		return ResponseEntity.ok(anoLetivoService.findByIdOrThrowBadRequest(id));
	}
	
	@PostMapping
    public ResponseEntity<AnoLetivo> save(@RequestBody @Valid AnoLetivoDTO anoLetivoDTO) {
        return new ResponseEntity<>(anoLetivoService.save(anoLetivoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	anoLetivoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnoLetivoDTO anoLetivoDTO) {
    	anoLetivoService.update(anoLetivoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
