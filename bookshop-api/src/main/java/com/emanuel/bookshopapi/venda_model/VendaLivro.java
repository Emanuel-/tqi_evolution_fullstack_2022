package com.emanuel.bookshopapi.venda_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class VendaLivro {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="nome_cliente")
	private String nomeCliente;
	
	@Column(name="cpf_cliente")
	private String cpfCliente;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="dados_da_compra")
	private String dadosDaCompra;
	
	@Column(name="qtd_itens")
	private String qtdItens;
	
	@Column(name="preco_total")
	private String precoTotal;
	
	public VendaLivro() {
		super();
	}

	public VendaLivro(long id, String nomeCliente, String cpfCliente, String genero, String dadosDaCompra,
			String qtdItens, String precoTotal) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.genero = genero;
		this.dadosDaCompra = dadosDaCompra;
		this.qtdItens = qtdItens;
		this.precoTotal = precoTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDadosDaCompra() {
		return dadosDaCompra;
	}

	public void setDadosDaCompra(String dadosDaCompra) {
		this.dadosDaCompra = dadosDaCompra;
	}

	public String getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(String qtdItens) {
		this.qtdItens = qtdItens;
	}

	public String getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(String precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	

}
