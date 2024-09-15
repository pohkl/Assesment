package com.assessment.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.assessment.demo.filter.CustomHeaderFilter;

@Configuration
public class SecurityConfig {

	private final CustomHeaderFilter customHeaderFilter;

    public SecurityConfig(CustomHeaderFilter customHeaderFilter) {
        this.customHeaderFilter = customHeaderFilter;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().permitAll()
        )
        .addFilterBefore(customHeaderFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}
