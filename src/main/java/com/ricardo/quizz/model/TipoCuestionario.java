package com.ricardo.quizz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tipo_cuestionario")
public class TipoCuestionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,unique = false)
	private String nombre;
		
	@OneToMany(mappedBy = "tipoCuestionario")
	@JsonIgnore
	private Set<Cuestionario> cuestionarios;

	public TipoCuestionario(int id, String nombre, Set<Cuestionario> cuestionarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cuestionarios = cuestionarios;
	}
	
	public TipoCuestionario() {}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cuestionario> getCuestionarios() {
		return cuestionarios;
	}

	public void setCuestionarios(Set<Cuestionario> cuestionarios) {
		this.cuestionarios = cuestionarios;
	}
	
	
}
