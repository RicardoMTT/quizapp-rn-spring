package com.ricardo.quizz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.quizz.model.Cuestionario;

@Repository
public interface CuestionarioRepository extends CrudRepository<Cuestionario, Integer> {

}
