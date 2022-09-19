package com.ricardo.quizz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.quizz.model.TipoCuestionario;
import com.ricardo.quizz.repositories.TipoCuestionarioRepository;
@Service
public class TipoCuestionarioService implements ITipoCuestionario {

	@Autowired
	TipoCuestionarioRepository tipoCuestionarioRepository;
	
	@Override
	public List<TipoCuestionario> findAllTipoCuestionario() {
		// TODO Auto-generated method stub
		return (List<TipoCuestionario>) tipoCuestionarioRepository.findAll();
	}

}
