package com.fcb.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class FCBSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userDetailsService ; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll()
		.antMatchers("/balanceenquery").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/login")
		.usernameParameter("userName")
		.passwordParameter("password")
		.defaultSuccessUrl("/balanceenquery")
		.failureUrl("/failureUrl")
		.and()
		.logout().logoutSuccessUrl("/home")
		.and().exceptionHandling().accessDeniedPage("/home")
		.and()
		.csrf();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("raja").password("raja").roles("ADMIN");
		auth.userDetailsService(userDetailsService);
	}

}
