package com.jaksona.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 应用安全配置
 * @author jaksona
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER").and()
					.withUser("admin").password("password").roles("ADMIN").and()
					.withUser("dba").password("password").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/", "/home")
					.permitAll()
				.antMatchers("/admin/**")
					.access("hasRole('ADMIN')")
				.antMatchers("/dba/**")
					.access("hasRole('DBA')")
					.and()
				.formLogin()
					.permitAll()
					.and()
				.logout()
					.permitAll()
					.and()
				.exceptionHandling()
					.accessDeniedPage("/Access_Denied");
	}
}
