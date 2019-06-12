package br.unipe.spotunipe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.
			authorizeRequests()//1. indica as requisições que serão feitas e que...
			.antMatchers("musica/add").hasAnyRole("ADM")//o antMatchers vai indicar que para acessar a página musicas/add o usuário deverá ser um ADM
			//.antMatchers("playlist/add").hasAnyRole("ADM")//o antMatchers vai indicar que para acessar a página playlist/add o usuário deverá ser um ADM
			.anyRequest()//2 ...qualquer uma necessitará de... 
				.authenticated()//3 ...autenticação
			.and()
				.formLogin()//formulário pré-formatado pelo próprio Spring Security
					.loginPage("/login")//indica qual será a página de login inserida pelo programador, que no caso, dentro de templates
					.permitAll();//permissão a todos que acessarem a app
	}
}
