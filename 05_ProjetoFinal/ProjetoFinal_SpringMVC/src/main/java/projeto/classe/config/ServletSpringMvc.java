package projeto.classe.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMvc extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] { AppWebConfiguration.class, JdbcSecurityConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { };
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String [] {"/"};
	}
}