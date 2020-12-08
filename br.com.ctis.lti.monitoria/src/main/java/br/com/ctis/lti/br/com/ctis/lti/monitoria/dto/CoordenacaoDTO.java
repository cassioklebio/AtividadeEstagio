package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Coordenacao;

public class CoordenacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Integer id;
	private String nome;
	private String email;
	private Integer fone;
	private String tipo;
	
	public CoordenacaoDTO() {
		
	}
	
	public CoordenacaoDTO(Coordenacao obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.fone = obj.getFone();
		this.tipo = obj.getTipo();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
