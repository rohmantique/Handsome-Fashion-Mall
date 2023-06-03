package com.hyundai.pjt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hyundai.pjt.security.handler.CustomAuthenticationFailureHandler;
import com.hyundai.pjt.security.handler.CustomAuthenticationSuccessHandler;
import com.hyundai.pjt.security.provider.CustomAuthenticationProvider;
import com.hyundai.pjt.security.service.HandsomeUserDetailsService;

import lombok.extern.log4j.Log4j2;

@EnableWebSecurity
@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new CustomAuthenticationProvider();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests().antMatchers("/**", "/main/**", "/mypage/reset/password").permitAll()
	        .antMatchers("/mypage/*").hasRole("USER")
	        
	        .anyRequest().authenticated().and()
	        .formLogin()
	        .loginPage("/member/CustomLogin")
	        .loginProcessingUrl("/member/login")
	        .defaultSuccessUrl("/main")
				
			.permitAll().and().csrf().disable();
	}

}
