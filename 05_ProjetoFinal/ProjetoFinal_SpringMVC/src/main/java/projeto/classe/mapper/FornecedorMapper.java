package projeto.classe.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import projeto.classe.models.Fornecedor;

public class FornecedorMapper implements RowMapper<Fornecedor>{

	@Override
	public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(rs.getInt("ID"));
		fornecedor.setNome(rs.getString("NOME"));
		fornecedor.setFone(rs.getString("FONE"));
		fornecedor.setEmail(rs.getString("EMAIL"));
		fornecedor.setSite(rs.getString("SITE"));
		fornecedor.setInstagram(rs.getString("INSTAGRAM"));
		fornecedor.setFacebook(rs.getString("FACEBOOK"));	
		return fornecedor;	
				
	}

}
