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

import br.com.app.modelo.domain.DTO.BimestreDTO;
import br.com.app.modelo.domain.model.Bimestre;
import br.com.app.modelo.domain.service.BimestreService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("bimestre")
public class BimestreController {
	
	private final BimestreService bimestreService;
	
	@GetMapping
	public ResponseEntity<Page<Bimestre>> list(Pageable pageable) {
		return ResponseEntity.ok(bimestreService.findAll(pageable));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Bimestre> findById(@PathVariable long id) {
		return ResponseEntity.ok(bimestreService.findByIdOrThrowBadRequest(id));
	}
	
	@PostMapping
    public ResponseEntity<Bimestre> save(@RequestBody @Valid BimestreDTO bimestreDTO) {
        return new ResponseEntity<>(bimestreService.save(bimestreDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	bimestreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BimestreDTO bimestreDTO) {
    	bimestreService.update(bimestreDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
