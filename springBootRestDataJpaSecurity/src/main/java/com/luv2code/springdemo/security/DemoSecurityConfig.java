package com.luv2code.springdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoSecurityConfig {
	
	@Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
	
	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http.authorizeHttpRequests(configurer ->
	                
	                configurer
	                        .antMatchers(HttpMethod.GET, "/rest/customers").hasRole("EMPLOYEE")
	                        .antMatchers(HttpMethod.GET, "/rest/customers/**").hasRole("EMPLOYEE")
	                        .antMatchers(HttpMethod.POST, "/rest/customers").hasRole("MANAGER")
	                        .antMatchers(HttpMethod.PUT, "/rest/customers").hasRole("MANAGER")
	                        .antMatchers(HttpMethod.DELETE, "/rest/customers/**").hasRole("ADMIN")
	        );

	        // use HTTP Basic authentication
	        http.httpBasic();

	        // disable Cross Site Request Forgery (CSRF)
	        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
	        http.csrf().disable();

	        return http.build();
	    }


}
