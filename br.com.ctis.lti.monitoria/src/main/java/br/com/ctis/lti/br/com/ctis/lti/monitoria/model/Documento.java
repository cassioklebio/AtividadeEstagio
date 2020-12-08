package br.com.ctis.lti.br.com.ctis.lti.monitoria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String caminho;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Coordenacao coordenacao;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Coordenacao coordenacaoCurso;
	
	public Documento(Integer id, String nome, String caminho) {
		super();
		this.id = id;
		this.nome = nome;
		this.caminho = caminho;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Coordenacao getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(Coordenacao coordenacaoMonitoria) {
		this.coordenacao = coordenacaoMonitoria;
	}

	public Coordenacao getCoordenacaoCurso() {
		return coordenacaoCurso;
	}

	public void setCoordenacaoCurso(Coordenacao coordenacaoCurso) {
		this.coordenacaoCurso = coordenacaoCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + ((coordenacaoCurso == null) ? 0 : coordenacaoCurso.hashCode());
		result = prime * result + ((coordenacao == null) ? 0 : coordenacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (coordenacaoCurso == null) {
			if (other.coordenacaoCurso != null)
				return false;
		} else if (!coordenacaoCurso.equals(other.coordenacaoCurso))
			return false;
		if (coordenacao == null) {
			if (other.coordenacao != null)
				return false;
		} else if (!coordenacao.equals(other.coordenacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", nome=" + nome + ", caminho=" + caminho + ", aluno=" + aluno
				+ ", coordenacaoMonitoria=" + coordenacao + ", coordenacaoCurso=" + coordenacaoCurso + "]";
	}

	
	
	
	

}
