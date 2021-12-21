package com.interview.activity.config;

import javax.security.auth.callback.PasswordCallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.interview.activity.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	// permission purpose
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/tokens").permitAll().anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
			http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authenticationmanagerbean() throws Exception {
		return super.authenticationManagerBean();
	}

}
