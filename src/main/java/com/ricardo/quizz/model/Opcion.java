package com.ricardo.quizz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Opcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean correct;
	
	private String content;
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "pregunta_id",nullable = false)//Se creara una columna con este nombre, el cual servira para hacer el join con la tabla Pregunta
	//@JsonIgnore
	//private Pregunta pregunta;//el nombre de esta prop "pregunta" debe coincidir con el que esta en el mappedBy de la entidad Pregunta

	public Opcion(boolean correct, String content) {
		super();
		this.correct = correct;
		//this.pregunta = pregunta;
		this.content = content;
	}
	
	public Opcion() {}
	
	public int getId() {
		return id;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
		
}
