package com.ricardo.quizz.services;

import java.util.List;

import com.ricardo.quizz.dto.PreguntaDto;
import com.ricardo.quizz.model.Pregunta;

public interface IPreguntaService {
	public List<Pregunta> findAll();
	public Pregunta create(PreguntaDto pregunta);

}
