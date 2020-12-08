package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Horario;

public class HorarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String horario;
	
	public HorarioDTO() {
		
	}

	public HorarioDTO(Horario obj) {
		this.id = obj.getId();
		this.horario = obj.getHorario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
	

}
