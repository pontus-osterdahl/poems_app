package com.example.poems_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.poems_app.filters.JwtRequestFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {
	
	@Autowired
	JwtRequestFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.authorizeHttpRequests((authz) -> authz
             .antMatchers(HttpMethod.GET).permitAll()
         )
		 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
         .httpBasic(withDefaults());
     return http.build();
	}
}
