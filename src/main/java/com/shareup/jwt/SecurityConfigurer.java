package com.shareup.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable()
			.authorizeRequests().antMatchers("/api/v1/users/authenticate")
			.permitAll().anyRequest().authenticated().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	}
	
	 @Override
	    public void configure(WebSecurity webSecurity) throws Exception {
	        webSecurity
	                .ignoring()
//	                .antMatchers(HttpMethod.POST, authenticationPath)
//	                .antMatchers(HttpMethod.POST, registerPath)
//	                .antMatchers(HttpMethod.OPTIONS, "/**")
//	                // whitelist all public urls here -- copy this line and modify:
//	                .antMatchers(HttpMethod.POST, "/email/**")
	                .antMatchers(HttpMethod.GET, "/user-post/**")
	                .antMatchers(HttpMethod.GET, "/user-stories/**")
	                .antMatchers(HttpMethod.GET, "/data/user/**")
					.antMatchers(HttpMethod.GET, "/data/group/**")
	                .antMatchers(HttpMethod.POST, "/api/v1/users/")
//	                .antMatchers(HttpMethod.GET, "/products/**")




//	        .antMatchers("/**")
	        ;
	    }
	 
	 

}
