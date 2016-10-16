package com.jaksona.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * 应用安全配置
 * @author jaksona
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication()
					.dataSource(dataSource)
					.passwordEncoder(new BCryptPasswordEncoder(8))
					.authoritiesByUsernameQuery("select username,r.name as authority from roles r left join user_role ur on ur.role_id = r.id left join users u on u.id = ur.user_id where u.username = ?")
					.groupAuthoritiesByUsername("select g.id, g.name as group_name, r.name as authority from groups g left join group_user gu on gu.group_id = g.id left join group_role gr on gr.group_id = g.id left join users u on u.id = gu.user_id left join roles r on r.id = gr.role_id where u.username = ? and g.id = gr.group_id and g.id = gu.group_id");
	}

	/**
	 * Override this method to expose the {@link AuthenticationManager} from
	 * {@link #configure(AuthenticationManagerBuilder)} to be exposed as a Bean. For
	 * example:
	 * <p>
	 * <pre>
	 * &#064;Bean(name name="myAuthenticationManager")
	 * &#064;Override
	 * public AuthenticationManager authenticationManagerBean() throws Exception {
	 *     return super.authenticationManagerBean();
	 * }
	 * </pre>
	 *
	 * @return the {@link AuthenticationManager}
	 * @throws Exception
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Override this method to configure {@link WebSecurity}. For example, if you wish to
	 * ignore certain requests.
	 *
	 * @param web
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/**/*.html");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeRequests()
				.antMatchers("/login.jsp").permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/login.jsp?authorization_error=true")
				.and()
				.csrf()
				.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
				.disable()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login.jsp")
				.and()
				.formLogin()
				.loginProcessingUrl("/login")
				.successForwardUrl("/index.html")
				.failureUrl("/login.jsp?authentication_error=true")
				.loginPage("/login.jsp");
		// @formatter:on
	}
}
