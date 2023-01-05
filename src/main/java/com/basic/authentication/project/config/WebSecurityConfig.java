package com.basic.authentication.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.basic.authentication.project.components.RequestTimeInterceptor;
import com.basic.authentication.project.components.security.CustomBasicAuthenticationEntryPoint;
import com.basic.authentication.project.components.security.CustomFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer{

	@Autowired
	private CustomBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("secret"))
				.authorities("ROLE_ADMIN");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/doc/**", "/v3/api-docs").permitAll()
			.anyRequest()
			.authenticated()
				.and()
				.httpBasic()
					.authenticationEntryPoint(authenticationEntryPoint);
		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);		
		return http.build();
	}

}
