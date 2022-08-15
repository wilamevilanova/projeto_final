package projeto.classe.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import projeto.classe.models.ProdutoApi;

public class ProdutoApiMapper implements RowMapper<ProdutoApi>{

	@Override
	public ProdutoApi mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProdutoApi produto = new ProdutoApi();
		produto.setId(rs.getInt("ID"));
		produto.setDescricao(rs.getString("DESCRICAO"));
		produto.setData(rs.getString("DATA"));
		produto.setResponsavel(rs.getString("RESPONSAVEL"));
		produto.setPreco_compra(rs.getDouble("PRECO_COMPRA"));
		produto.setPreco_venda(rs.getDouble("PRECO_VENDA"));
		return produto;	
		
		
	}
	
}
