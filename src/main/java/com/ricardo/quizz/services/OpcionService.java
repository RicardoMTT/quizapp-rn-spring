package com.ricardo.quizz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ricardo.quizz.dto.OpcionDto;
import com.ricardo.quizz.model.Opcion;
import com.ricardo.quizz.model.Pregunta;
import com.ricardo.quizz.repositories.OpcionRepository;
import com.ricardo.quizz.repositories.PreguntaRepository;

@Service
public class OpcionService implements IOpcionService{
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private OpcionRepository opcionRepository;

	@Override
	public Opcion createOpcion(OpcionDto opc) {
		Opcion opcion = new Opcion();
		opcion.setContent(opc.getContent());
		opcion.setCorrect(opc.isCorrect());
		Optional<Pregunta> preguntaOpt = preguntaRepository.findById(opc.getPregunta());
		if(preguntaOpt.isPresent()) {
			System.out.println("!111");
			//opcion.setPregunta(preguntaOpt.get());
		}
		System.out.println("222");
		opcionRepository.save(opcion);
		return opcion;
	}

	@Override
	public List<Opcion> findAllOpcion() {
		return (List<Opcion>) opcionRepository.findAll();
	}

	

	
}
