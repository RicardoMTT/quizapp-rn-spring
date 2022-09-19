package com.ricardo.quizz.dto;

import java.util.List;

import com.ricardo.quizz.model.Opcion;

public class PreguntaDto {
	
	private Integer id;
	private String description;
	private Integer cuestionario;

	private List<Opcion> opciones;
	
	public PreguntaDto(Integer id, String description, Integer cuestionario,List<Opcion> opciones) {
		super();
		this.id = id;
		this.description = description;
		this.cuestionario = cuestionario;
		this.opciones = opciones;
	}
	
	public PreguntaDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCuestionario() {
		return cuestionario;
	}

	public void setCuestionario(Integer cuestionario) {
		this.cuestionario = cuestionario;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

}
