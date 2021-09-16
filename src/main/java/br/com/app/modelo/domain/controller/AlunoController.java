package br.com.app.modelo.domain.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.modelo.domain.DTO.AlunoDTO;
import br.com.app.modelo.domain.model.Aluno;
import br.com.app.modelo.domain.service.AlunoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("alunos")
public class AlunoController {
	
	private final AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<Page<Aluno>> list(Pageable pageable) {
		return ResponseEntity.ok(alunoService.findAll(pageable));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id) {
		return ResponseEntity.ok(alunoService.findByIdOrThrowBadRequest(id));
	}
	
	@GetMapping(path = "/buscar")
	public ResponseEntity<List<Aluno>> findByNome(@RequestParam String nome) {
		return ResponseEntity.ok(alunoService.findByName(nome));
	}
	
	@PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoDTO alunoDTO) {
        return new ResponseEntity<>(alunoService.save(alunoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	alunoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody AlunoDTO alunoDTO) {
    	alunoService.update(alunoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
	@PostMapping(path = "/matricular")
    public void matricular(@RequestBody @Valid AlunoDTO alunoDTO) {
		alunoService.matricular(alunoDTO);
    }

}
