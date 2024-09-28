package br.com.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String conteudo;
	
	private String autor;
	
	@Temporal(TemporalType.TIME)
	private Date tempoCriacao = new Date();
	
	
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getTempoCriacao() {
		return tempoCriacao;
	}

	public void setTempoCriacao(Date tempoCriacao) {
		this.tempoCriacao = tempoCriacao;
	}
	
	
}
