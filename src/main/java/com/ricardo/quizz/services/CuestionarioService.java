package com.ricardo.quizz.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ricardo.quizz.dto.CuestionarioDto;
import com.ricardo.quizz.model.Cuestionario;
import com.ricardo.quizz.model.Opcion;
import com.ricardo.quizz.model.Pregunta;
import com.ricardo.quizz.model.TipoCuestionario;
import com.ricardo.quizz.repositories.CuestionarioRepository;
import com.ricardo.quizz.repositories.TipoCuestionarioRepository;

@Service
public class CuestionarioService implements ICuestionarioService{

	@Autowired
	CuestionarioRepository cuestionarioRepository;

	@Autowired
	TipoCuestionarioRepository tipoCuestionarioRepository;
	
	@Override
	public Cuestionario findCuestionarioById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuestionario> findCuestionarios() {
		return (List<Cuestionario>) cuestionarioRepository.findAll();
	}

	@Override
	public Cuestionario createCuestionario(CuestionarioDto cuestionario) {
		
		Cuestionario newCuestionario = new Cuestionario();
		
		newCuestionario.setName(cuestionario.getName());
		
		Optional<TipoCuestionario> tipoCuestionarioOpt = tipoCuestionarioRepository.findById(cuestionario.getTipoCuestionario());
		
		if(tipoCuestionarioOpt.isPresent()) {
			newCuestionario.setTipoCuestionario(tipoCuestionarioOpt.get());
		}
		
		cuestionario.getPreguntas().forEach(pregunta->newCuestionario.addPregunta(pregunta));

				cuestionarioRepository.save(newCuestionario);
		return newCuestionario;
	}

	
}
