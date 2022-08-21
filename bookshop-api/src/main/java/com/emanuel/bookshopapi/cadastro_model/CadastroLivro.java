package com.emanuel.bookshopapi.cadastro_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastros")
public class CadastroLivro {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="cod_livro")
	private String codLivro;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="editora")
	private String editora;
	
	@Column(name="ano_pub")
	private String anoPub;
	
	@Column(name="img_livro")
	private String imgLivro;
	

	public CadastroLivro() {
		super();
	}

	public CadastroLivro(long id, String codLivro, String titulo, String autor, String editora, String anoPub,
			String imgLivro) {
		super();
		this.id = id;
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoPub = anoPub;
		this.imgLivro = imgLivro;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(String codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAnoPub() {
		return anoPub;
	}
	public void setAnoPub(String anoPub) {
		this.anoPub = anoPub;
	}
	public String getImgLivro() {
		return imgLivro;
	}
	public void setImgLivro(String imgLivro) {
		this.imgLivro = imgLivro;
	}
	
	

}
