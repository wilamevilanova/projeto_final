package projeto.classe.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import projeto.classe.models.Produto;

public class ProdutoMapper implements RowMapper<Produto>{

	@Override
	public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("ID"));
		produto.setDescricao(rs.getString("DESCRICAO"));
		produto.setData(rs.getDate("DATA"));
		produto.setResponsavel(rs.getString("RESPONSAVEL"));
		produto.setPreco_compra(rs.getDouble("PRECO_COMPRA"));
		produto.setPreco_venda(rs.getDouble("PRECO_VENDA"));
		return produto;	
		
	}

}
