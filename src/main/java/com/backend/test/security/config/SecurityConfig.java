package com.backend.test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/address_blocks").permitAll()
				.antMatchers("/list_addresses").permitAll()
				.antMatchers("/index").hasAnyRole("USER","ADMIN","DBA")
				.antMatchers("/usr/**").hasAnyRole("USER","ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/dba/**").hasRole("DBA")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/index")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("ADMIN").and()
				.withUser("dba").password("password").roles("DBA", "ADMIN");
	}
}
