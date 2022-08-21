package com.emanuel.bookshopapi.compra_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class CompraLivro {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="cod_livro")
	private String codLivro;
	
	@Column(name="qtd_livros")
	private String qtdLivros;
	
	@Column(name="val_unit")
	private String valUnit;
	
	public CompraLivro() {
		super();
	}

	public CompraLivro(long id, String codLivro, String qtdLivros, String valUnit) {
		super();
		this.id = id;
		this.codLivro = codLivro;
		this.qtdLivros = qtdLivros;
		this.valUnit = valUnit;
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

	public String getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(String qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public String getValUnit() {
		return valUnit;
	}

	public void setValUnit(String valUnit) {
		this.valUnit = valUnit;
	}
	
	

}
