package com.prof.demo.config;

/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package org.springframework.security.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
      @Autowired
    private AccessDeniedHandler accessDeniedHandler;

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/Lien","/Source","/DTO","/header","/", "/home", "/about","/webjars/**").permitAll()
                                .antMatchers("/css/**").permitAll()
                                .antMatchers("/salle/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login") //
				.permitAll()
				.and()
			.logout()
				.permitAll()
                        .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	// @formatter:on

	// @formatter:off
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//User.withDefaultPasswordEncoder().username("admin").password("{noop}123").roles("ADMIN").build(); 
	 auth
                .inMemoryAuthentication()
                .withUser(User
                        .withDefaultPasswordEncoder()
                        .username("admin")
                        .password("123")
                        .roles("ADMIN").build());
        
        }
	// @formatter:on
}
