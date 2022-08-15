package projeto.classe.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import projeto.classe.dao.Dao;
import projeto.classe.dao.UsuariosDao;


@EnableWebMvc


@ComponentScan(basePackages = "projeto.classe.controllers")

public class AppWebConfiguration {

	// OBJETO QUE ESPECIFICA ONDE IRÁ FICAR OS ARQUIVOS JSP
	@Bean
	public InternalResourceViewResolver internalViewResolver() { // InternalResourceViewResolver
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	// OBJETO QUE DE CONEXÃO COM O BANCO DE DADOS
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_estoque?useSSL=false&allowPublicKeyRetrieval=true");
		dataSource.setUsername("root");
		dataSource.setPassword("Wi04133012");
		return dataSource;
		
	}

	@Bean
	public Dao getDao() {
		return new Dao(dataSource());

	}

	@Bean
	public UsuariosDao getUsuariosDao() {
		return new UsuariosDao(dataSource());
	}
}
