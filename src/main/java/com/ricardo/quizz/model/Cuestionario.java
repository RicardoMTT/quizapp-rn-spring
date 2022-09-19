package com.ricardo.quizz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cuestionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	
	@OneToMany(mappedBy = "cuestionario",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Pregunta> preguntas = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_cuestionario_id",nullable = false)
	private TipoCuestionario tipoCuestionario;
	
	@JsonCreator
	public Cuestionario(@JsonProperty int id,@JsonProperty String name,@JsonProperty List<Pregunta> preguntas,@JsonProperty TipoCuestionario tipoCuestionario) {
		super();
		this.id = id;
		this.name = name;
		this.preguntas = preguntas;
		this.tipoCuestionario = tipoCuestionario;
	}

	public Cuestionario() {}

	public int getId() {
		return id;
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

	public TipoCuestionario getTipoCuestionario() {
		return tipoCuestionario;
	}

	public void setTipoCuestionario(TipoCuestionario tipoCuestionario) {
		this.tipoCuestionario = tipoCuestionario;
	}

	public void addPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
		pregunta.setCuestionario(this);
	}
}
