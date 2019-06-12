package br.unipe.spotunipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@Configuration//indicamos ao Spring que esta é uma classe de configuração
public class ConfiguracaoSpringMVC extends WebMvcConfigurerAdapter{//neste caso, o template Engine que estamos utilizando é o THYMELEAF

	@Bean//notação declarada em métodos de classe que possuem a notação @Configuration
	public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver resolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(resolver);
		return templateEngine;
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");//a view home que existe em src/main/resources/templates será exibida ao chamar o link "/"
		registry.addViewController("/home").setViewName("home");//a view home que existe em src/main/resources/templates será exibida ao chamar o link "/home"
	}
	
}
