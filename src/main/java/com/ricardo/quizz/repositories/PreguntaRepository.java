package com.ricardo.quizz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.quizz.model.Pregunta;
@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Integer>{

}
