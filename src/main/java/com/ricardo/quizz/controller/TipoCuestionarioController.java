package com.ricardo.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.quizz.model.TipoCuestionario;
import com.ricardo.quizz.services.TipoCuestionarioService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TipoCuestionarioController {

	
	@Autowired
	TipoCuestionarioService tipoCuestionarioService;
	
	@GetMapping("/lista-tipos")
	public ResponseEntity<List<TipoCuestionario>> getAllTipoCuestionario(){
		return ResponseEntity.ok(tipoCuestionarioService.findAllTipoCuestionario());
	}
}
