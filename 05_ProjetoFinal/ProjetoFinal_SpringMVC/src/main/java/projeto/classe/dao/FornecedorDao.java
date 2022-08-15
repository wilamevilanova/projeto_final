package projeto.classe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import projeto.classe.mapper.FornecedorMapper;
import projeto.classe.models.Fornecedor;

@Repository
public class FornecedorDao {
	
	private JdbcTemplate jdbcTemplate;

	public FornecedorDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void incluirFornecedor(Fornecedor fornecedor) throws Exception {
		try {
			String sql = "INSERT INTO TB_FORNECEDOR (NOME, FONE, EMAIL, SITE, INSTAGRAM, FACEBOOK)"
					+ " VALUES (?, ? ,? ,? ,?, ?)";
			this.jdbcTemplate.update(sql,
					fornecedor.getNome(),
					fornecedor.getFone(),
					fornecedor.getEmail(),
					fornecedor.getSite(),
					fornecedor.getInstagram(),
					fornecedor.getFacebook());
			
		} catch (Exception e) {
			throw e;
		}
	}
		//MÉTODO PARA ALTERAR UM FORNECEDOR
		public void alterarFornecedor (Fornecedor fornecedor) throws Exception {
			try {
				String sql = "UPDATE TB_FORNECEDOR SET NOME=?, FONE=?, EMAIL=?, SITE=?, INSTAGRAM=?, FACEBOOK=?"
						+ " WHERE ID=?";
				
				this.jdbcTemplate.update(sql,
						fornecedor.getNome(),
						fornecedor.getFone(),
						fornecedor.getEmail(),
						fornecedor.getSite(),
						fornecedor.getInstagram(),
						fornecedor.getFacebook());
			} catch (Exception e) {
				throw e;
			}
		}
	
		//MÉTODO PRARA LISTA TODOS OS Fornecedores
		public List<Fornecedor> listarFornecedores () throws Exception {
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			try {
				fornecedores = this.jdbcTemplate.query
						("SELECT * FROM TB_FORNECEDOR", new FornecedorMapper());
			} catch (Exception e) {
				throw e;
			}
			return fornecedores;
		}
		
		//MÉTODO PARA BUSCAR UM FORNECEDOR PELO ID

		public Fornecedor buscarFornedores (int id)  throws Exception {
			Fornecedor fornecedor = null;
			try {
				fornecedor = this.jdbcTemplate.queryForObject(
						"SELECT * FROM TB_PRODUTOS WHERE ID = ?", 
						new FornecedorMapper(),
						new Object[] { id });//lista de argumentos
			} catch (Exception e) {
				throw e;
			}
			return fornecedor;
		}
		
		//MÉTODO PARA EXCLUIR UM FORNECEDOR PELO ID
		public int excluirFornecedor (int id) throws Exception {
			int registros = 0;
		
			try {
				this.jdbcTemplate.update("DELETE FROM TB_FORNECEDOR ID = ?", id);
				
				registros = this.jdbcTemplate.update("DELETE FROMTB_FORNECEDOR WHERE ID = ?", id);
				
			} catch (Exception e) {
				throw e;
			}
			return registros;
		}
		
	}

