package br.com.ctis.lti.br.com.ctis.lti.monitoria.dto;

import java.io.Serializable;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Documento;



public class DocumentoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;	
	private String nome;
	private String caminho;
	
	

	public DocumentoDTO(Documento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.caminho = obj.getCaminho();
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

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
