package projeto.classe.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	private String usersQuery ="SELECT username, password, enabled from users where username = ?";
		
	private String authoritiesQuery =
	"SELECT u.username, a.authority " +
			"FROM user_authorities a, users u " +
			"WHERE u.username = ? " +
			"AND u.id = a.user_id";
	
	@Autowired
	private DataSource dataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(authoritiesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/incluir").authenticated()
			.antMatchers("/api/**").permitAll()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.formLogin();
			
	}

}