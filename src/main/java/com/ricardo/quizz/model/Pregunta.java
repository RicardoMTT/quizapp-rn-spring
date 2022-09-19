package com.ricardo.quizz.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//ManyToOne:asociación secundaria, ya que asigna la columna de clave externa subyacente,aca no va el CascadeType.ALL
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cuestionario_id",nullable = false)
	@JsonIgnore
	private Cuestionario cuestionario;
	
	private String descripcion;
	//Con mappedBy indico que es bidireccional, por lo que la entidad Opcion tambien tendra una relacion hacia pregunta
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	//https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save
	private List<Opcion> opciones = new ArrayList<>();
	
	public Pregunta() {
		
	}
	
	@JsonCreator
	public Pregunta(@JsonProperty Cuestionario cuestionario,@JsonProperty String descripcion) {
		super();
		this.cuestionario = cuestionario;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public Cuestionario getCuestionario() {
		return cuestionario;
	}

	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Opcion> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public void addOpcion(Opcion opcion) {
		this.opciones.add(opcion);
		//opcion.setPregunta(this);
	}
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

