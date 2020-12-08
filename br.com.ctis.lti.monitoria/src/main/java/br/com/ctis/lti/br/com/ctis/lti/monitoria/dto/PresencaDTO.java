package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;
import java.util.List;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Horario;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Presenca;

public class PresencaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String presenca;
	private Horario horario;
	
	public PresencaDTO() {
		
	}

	public PresencaDTO(Presenca obj) {
		this.id = obj.getId();
		this.presenca = obj.getPresenca();
		this.horario = obj.getHorario();
	}

	

	

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	
	
	
	
	

}
