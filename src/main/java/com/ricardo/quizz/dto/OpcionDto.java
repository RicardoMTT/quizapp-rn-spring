package com.ricardo.quizz.dto;

public class OpcionDto {

	private Integer id;
	private String content;
	private boolean correct;
	private Integer pregunta;
	
	public OpcionDto(Integer id, String content, boolean correct, Integer pregunta) {
		super();
		this.id = id;
		this.content = content;
		this.correct = correct;
		this.pregunta = pregunta;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public Integer getPregunta() {
		return pregunta;
	}
	public void setPregunta(Integer pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
