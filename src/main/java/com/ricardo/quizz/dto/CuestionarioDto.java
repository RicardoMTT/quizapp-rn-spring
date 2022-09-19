package com.ricardo.quizz.dto;

import java.util.List;
import com.ricardo.quizz.model.Pregunta;

public class CuestionarioDto {
	private Integer id;
	private String name;
	private List<Pregunta> preguntas;
	private Integer tipoCuestionario;
	
	
	public CuestionarioDto() {
	}
	public CuestionarioDto(Integer id, String name, List<Pregunta> preguntas, Integer tipoCuestionario) {
		super();
		this.id = id;
		this.name = name;
		this.preguntas = preguntas;
		this.tipoCuestionario = tipoCuestionario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public Integer getTipoCuestionario() {
		return tipoCuestionario;
	}
	public void setTipoCuestionario(Integer tipoCuestionario) {
		this.tipoCuestionario = tipoCuestionario;
	}
	
	
	
}
