package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;

public class CursoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String curso;
	
	public CursoDTO() {
		
	}

	public CursoDTO(Curso obj) {
		this.id = obj.getId();
		this.curso = obj.getCurso();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
