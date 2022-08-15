package projeto.classe.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;

import projeto.classe.models.Role;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		
		role.setId(rs.getInt("ID"));
		role.setRole(rs.getString("AUTHORITY"));
		role.setUserid(rs.getInt("USER_ID"));
		return role;
		
	}

}