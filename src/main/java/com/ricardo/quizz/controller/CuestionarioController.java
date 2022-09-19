package com.ricardo.quizz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.quizz.dto.CuestionarioDto;
import com.ricardo.quizz.model.Cuestionario;
import com.ricardo.quizz.services.CuestionarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CuestionarioController {

	@Autowired
	CuestionarioService cuestionarioService;

	
	@GetMapping("/listar-todo")
	public ResponseEntity<List<Cuestionario>> getCuestionarios() {
		return new ResponseEntity<>(cuestionarioService.findCuestionarios(),HttpStatus.OK);
	}
	
	@PostMapping("/add-cuestionario")
	public ResponseEntity<Cuestionario> createCuestionario(@RequestBody CuestionarioDto cuestionario){
		return new ResponseEntity<>(cuestionarioService.createCuestionario(cuestionario),HttpStatus.CREATED);
	}
	
	@GetMapping("/cuestionarioPorTipo/{tipo}")
	public ResponseEntity<Cuestionario> getCuestionarioPorTipo(@PathVariable("tipo") String tipo){
		List<Cuestionario> cuestionarios = cuestionarioService.findCuestionarios();
		Optional<Cuestionario> cuestionarioResponse = cuestionarios.stream().
				filter(cuestionario->cuestionario.getTipoCuestionario().getNombre().equals(tipo)).findFirst();
		if(cuestionarioResponse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cuestionarioResponse.get());
	}
 }
