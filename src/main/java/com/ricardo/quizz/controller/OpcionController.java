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

import com.ricardo.quizz.services.OpcionService;
import com.ricardo.quizz.dto.OpcionDto;
import com.ricardo.quizz.model.Opcion;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OpcionController {

	@Autowired
	private OpcionService opcionService;
	
	@PostMapping(path = "/add-opcion")
	public ResponseEntity<Opcion> create(@RequestBody OpcionDto opcionDto){
		return new ResponseEntity<Opcion>(opcionService.createOpcion(opcionDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/lista-opciones")
	public ResponseEntity<List<Opcion>> getOptions() {
		return new ResponseEntity<>(opcionService.findAllOpcion(),HttpStatus.OK);
	}
}
