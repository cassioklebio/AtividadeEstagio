package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Aluno;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Professor;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Vaga;

public class VagaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
    private String nome;
	private Professor professor;
	private Curso curso;
	
    public VagaDTO(){
		
	}	
	
	public VagaDTO(Vaga obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.professor = obj.getProfessor();
		this.curso = obj.getCurso();
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
