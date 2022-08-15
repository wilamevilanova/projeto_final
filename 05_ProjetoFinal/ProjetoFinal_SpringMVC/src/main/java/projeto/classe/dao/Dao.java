package projeto.classe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import projeto.classe.mapper.ProdutoApiMapper;
import projeto.classe.mapper.ProdutoMapper;
import projeto.classe.models.Produto;
import projeto.classe.models.ProdutoApi;



public class Dao {
	
	private JdbcTemplate jdbcTemplate;
	
	public Dao(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);	
	}

	//MÉTODO PARA INCLUIR UM NOVO PRODUTO
	public void incluirProduto (Produto produto) throws Exception {
		try {
			String sql = "INSERT INTO TB_PRODUTOS (DESCRICAO, DATA, RESPONSAVEL, PRECO_COMPRA, PRECO_VENDA)"
					+ " VALUES (?, ?, ?, ?, ?)";
			this.jdbcTemplate.update(sql,
					produto.getDescricao(),
					new java.sql.Date(produto.getData().getTime()),
					produto.getResponsavel(),
					produto.getPreco_compra(),
					produto.getPreco_venda());
			
		} catch (Exception e) {
			throw e;
		}
	}
		
	//MÉTODO PARA ALTERAR UM PRODUTO
	public void alterarProduto (Produto produto) throws Exception {
		try {
			String sql = "UPDATE TB_PRODUTOS SET DESCRICAO=?, DATA=?, RESPONSAVEL=?, PRECO_COMPRA=?, PRECO_VENDA=?"
					+ " WHERE ID=?";
			
			this.jdbcTemplate.update(sql,
					produto.getDescricao(),
					new java.sql.Date(produto.getData().getTime()),
					produto.getResponsavel(),
					produto.getPreco_compra(),
					produto.getPreco_venda(),
				produto.getId());
		} catch (Exception e) {
			throw e;
		}
	}

	
	//MÉTODO PRARA LISTA TODOS OS PRODUTO
	public List<Produto> listarProdudos () throws Exception {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = this.jdbcTemplate.query
					("SELECT * FROM TB_PRODUTOS", new ProdutoMapper());
		} catch (Exception e) {
			throw e;
		}
		return produtos;
	}
	
	//MÉTODO PARA BUSCAR UM PRODUTO PELO ID

	public Produto buscarProduto (int id)  throws Exception {
		Produto produto = null;
		try {
			produto = this.jdbcTemplate.queryForObject(
					"SELECT * FROM TB_PRODUTOS WHERE ID = ?", 
					new ProdutoMapper(),
					new Object[] { id });//lista de argumentos
		} catch (Exception e) {
			throw e;
		}
		return produto;
	}
	
	//MÉTODO PARA EXCLUIR UM PRODUTO PELO ID
	public int excluirProduto (int id) throws Exception {
		int registros = 0;
	
		try {
			this.jdbcTemplate.update("DELETE FROM TB_PRODUTOS WHERE ID = ?", id);
			
			registros = this.jdbcTemplate.update("DELETE FROM TB_PRODUTOS WHERE ID = ?", id);
			
		} catch (Exception e) {
			throw e;
		}
		return registros;
	}
	

	//NOVOS MÉTODOS BASEADOS NO MODELO PRODUTO API
	//COM O PROPÓSITO DE SERVIR PARA COMSUMO DE API CRIAR NESTE PROJETO
	
	//MÉTODO PARA INCLUIR UM NOVO PRODUTO	
	public void incluirProduto (ProdutoApi produto) throws Exception {
		try {
			String sql = "INSERT INTO TB_PRODUTOS (DESCRICAO, DATA, RESPONSAVEL, PRECO_COMPRA, PRECO_VENDA)"
					+ " VALUES (?, ?, ?, ?, ?)";
			this.jdbcTemplate.update(sql,
					produto.getDescricao(),
					produto.getData(),
					produto.getResponsavel(),
					produto.getPreco_compra(),
					produto.getPreco_venda());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//MÉTODO PRA LISTA TODOS OS PRODUTOS
	public List<ProdutoApi> listarProdutosApi () throws Exception {
		List<ProdutoApi> produtos = new ArrayList<ProdutoApi>();
		try {
			produtos = this.jdbcTemplate.query("SELECT * FROM TB_PRODUTOS", new ProdutoApiMapper());
		} catch (Exception e) {
			throw e;
		}
		return produtos;
	}
	
	//MÉTODO PARA BUSCAR UM PRODUTOAPI PELO ID
	public ProdutoApi buscarProdutoApi (int id)  throws Exception {
		ProdutoApi produto = null;
		try {
			produto = this.jdbcTemplate.queryForObject(
					"SELECT * FROM TB_PRODUTOS WHERE ID = ?", 
					new ProdutoApiMapper(),
					new Object[] { id });//lista de argumentos
		} catch (Exception e) {
			throw e;
		}
		return produto;
	}
}