package projeto.classe.models;

import java.util.List;

public class  ProdutoApi {

	private int id;
	private String descricao;
	private String responsavel;
	private String data;
	private Double preco_compra;
	private Double preco_venda;
	private List<Fornecedor> fornecedors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(Double preco_compra) {
		this.preco_compra = preco_compra;
	}

	public Double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public List<Fornecedor> getConvidados() {
		return fornecedors;
	}

	public void setConvidados(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	@Override
	public String toString() {
		return "ID:" + this.getId() + ", Descrição: " + this.getDescricao();
	}
}
