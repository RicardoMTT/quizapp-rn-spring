package com.ricardo.quizz.services;

import java.util.List;

import com.ricardo.quizz.dto.OpcionDto;
import com.ricardo.quizz.model.Opcion;

public interface IOpcionService {

	public Opcion createOpcion(OpcionDto opc);
	public List<Opcion> findAllOpcion();
}
