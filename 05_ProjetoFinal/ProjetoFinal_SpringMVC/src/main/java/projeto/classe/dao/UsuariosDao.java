package projeto.classe.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import projeto.classe.mapper.RoleMapper;
import projeto.classe.mapper.UserMapper;
import projeto.classe.models.Role;
import projeto.classe.models.UserInfo;

@Repository
public class UsuariosDao implements UserDetailsService {
	
	private JdbcTemplate jdbcTemplate;

	public UsuariosDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void incluirUsuario(UserInfo user) throws Exception {
		try {
			String sql = "INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)"
					+ " VALUES (?, ? ,?)";
			this.jdbcTemplate.update(sql,
					user.getLogin(),
					user.getPassword(),
					user.isEnabled());
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public List<Role> listarRoles(int user_id) throws RuntimeException {
		List<Role> roles = new ArrayList<Role>();
		try {
			String  sql = "SELECT * FROM user_authorities WHERE user_id = ?";
			roles = this.jdbcTemplate.query(sql, new RoleMapper(), new Object[] {user_id});
		} catch (Exception e) {
			throw e;
		}
		return roles;
	}
	
	public UserInfo buscarUsuario(String username) throws RuntimeException {
		UserInfo user = null;
		try {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			user = this.jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[] {username});
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserInfo user = this.buscarUsuario(username);
			if (user == null) {
				throw new UsernameNotFoundException("O usuário " + username + " não existe.");
			}
			List<Role> roles = this.listarRoles(user.getId());
			user.setRoles(roles);
			return user;
		} catch (UsernameNotFoundException e) {
			throw e;
		}
	}
}