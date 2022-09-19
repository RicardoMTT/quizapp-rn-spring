package com.ricardo.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.quizz.dto.PreguntaDto;
import com.ricardo.quizz.model.Pregunta;
import com.ricardo.quizz.services.PreguntaService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PreguntaController {

	@Autowired
	PreguntaService preguntaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Pregunta>> greeting() {
		return new ResponseEntity<>(preguntaService.findAll(),HttpStatus.OK);
	}
	@PostMapping(path = "/agregar-pregunta")
	public ResponseEntity<Pregunta> create(@RequestBody PreguntaDto preguntaDto){
		return new ResponseEntity<Pregunta>(preguntaService.create(preguntaDto),HttpStatus.CREATED);
	}
	
}
