package projeto.classe.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class Produto {

	private int id;
	
	@NotEmpty(message = "A descrição deve ser informada")
	@Size(min = 2, max=45, message = "A descrição deve ter até 45 caracteres")
	private String descricao;
	
	@NotEmpty(message = "O nome do responsável deve ser informado")
	@Size(max=10, message = "O nome do responsavel deve ter até 10 caracteres")
	private String responsavel;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@NotEmpty(message = "O valor da compra deve ser informado")
	@Size(max=10, message = "O valor da compra deve ter até 4 digitos")
	private Double preco_compra;
	
	@NotEmpty(message = "O valor da venda deve ser informado")
	@Size(max=10, message = "O valor da venda deve ter até 4 digitos")
	private Double preco_venda;
	private List<Fornecedor> fornecedor;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "ID:" + this.getId() + ", Descrição: " + this.getDescricao();
	}
}
