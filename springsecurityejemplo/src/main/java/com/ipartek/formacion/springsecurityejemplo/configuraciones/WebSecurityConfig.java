package com.ipartek.formacion.springsecurityejemplo.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//Ver en https://spring.io/guides/gs/securing-web/
	//Configura los accesos
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/", "/home").permitAll() //Permite a todo el mundo entrar a home
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login") //Permite a todo el mundo entrar en login
			.permitAll()
			.and()
		.logout()
			.permitAll(); //Se permite a todo el mundo salir
	}

	//Cosntruyo un usuario y lo de vuelvo en InMemoryUserDetailsManager
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user);
	}


	
}
