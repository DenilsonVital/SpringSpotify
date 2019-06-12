package br.unipe.spotunipe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//classe responsável por criar os logins e senhas
@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("adm").password("123456").roles("add")//criará o usuário adm como ADM do sistema e com a senha 123456
			.and()//o and dividirá os usuários do sistema
			.withUser("usuario").password("1234").roles("list");//criará o usuário usuarui como USER do sistema
			}
	

}
