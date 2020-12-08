package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Professor;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Semestre;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Turno;

public class ProfessorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	private Integer fone;
	private Curso curso;
	private Semestre semestre;
	private Turno turno;
		
	
	public ProfessorDTO() {
		
	}

	public ProfessorDTO(Professor obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.fone = obj.getFone();
		this.curso = obj.getCurso();
		this.semestre = obj.getSemestre();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFone() {
		return fone;
	}

	public void setFone(Integer fone) {
		this.fone = fone;
	}
	
	
	

}
