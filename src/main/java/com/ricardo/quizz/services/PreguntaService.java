package com.ricardo.quizz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.quizz.dto.PreguntaDto;
import com.ricardo.quizz.model.Cuestionario;
import com.ricardo.quizz.model.Pregunta;
import com.ricardo.quizz.repositories.CuestionarioRepository;
import com.ricardo.quizz.repositories.PreguntaRepository;

@Service
public class PreguntaService implements IPreguntaService {

	@Autowired
	private CuestionarioRepository cuestionarioRepository;

	@Autowired
	private PreguntaRepository preguntaRepository;

	@Override
	public List<Pregunta> findAll() {
		// TODO Auto-generated method stub
		return (List<Pregunta>) preguntaRepository.findAll();
	}

	@Override
	public Pregunta create(PreguntaDto pregunta) {
		Pregunta newPregunta = new Pregunta();
		
		newPregunta.setDescripcion(pregunta.getDescription());
		
		Optional<Cuestionario> cuestionarioOpt = cuestionarioRepository.findById(pregunta.getCuestionario());
		
		if(cuestionarioOpt.isPresent()) {
			newPregunta.setCuestionario(cuestionarioOpt.get());
		}

		
		pregunta.getOpciones().forEach(opcion -> newPregunta.addOpcion(opcion));	
		
		preguntaRepository.save(newPregunta);
		return newPregunta;
	}
	
	
	
	
	
}
