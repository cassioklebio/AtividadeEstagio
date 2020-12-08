package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Semestre;

public class SemestreDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private String semestre;
	
	public SemestreDTO() {
		
	}
	
	public SemestreDTO(Semestre obj) {
		this.id = obj.getId();
		this.semestre = obj.getSemestre();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	

}
