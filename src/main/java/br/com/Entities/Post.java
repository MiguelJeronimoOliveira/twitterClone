package br.com.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String conteudo;
	
	@ManyToOne
	private Usuario autor;
	
	private String nomeAutor;
	
	@Temporal(TemporalType.TIME)
	private Date tempoCriacao = new Date();
	
	@Temporal(TemporalType.DATE)
	private Date diaCriacao = new Date();
	
	private EditedEnum editado;
	
	
	public EditedEnum getEditado() {
		return editado;
	}

	public void setEditado(EditedEnum editado) {
		this.editado = editado;
	}

	// getters e setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Date getTempoCriacao() {
		return tempoCriacao;
	}

	public void setTempoCriacao(Date tempoCriacao) {
		this.tempoCriacao = tempoCriacao;
	}

	public Date getDiaCriacao() {
		return diaCriacao;
	}

	public void setDiaCriacao(Date diaCriacao) {
		this.diaCriacao = diaCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	
}
