package com.ricardo.quizz.services;

import java.util.List;

import com.ricardo.quizz.dto.CuestionarioDto;
import com.ricardo.quizz.model.Cuestionario;

public interface ICuestionarioService {
	public Cuestionario findCuestionarioById(Long id);
	public List<Cuestionario> findCuestionarios();
	public Cuestionario createCuestionario(CuestionarioDto cuestionario);

}
