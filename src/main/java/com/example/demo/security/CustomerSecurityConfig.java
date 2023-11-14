package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.example.demo.service.AdminUserDetailsService;
import com.example.demo.service.CustomerUserDetailsService;

import jakarta.security.auth.message.config.AuthConfig;
import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@Order(2)
public class CustomerSecurityConfig {
	@Bean
	public PasswordEncoder customerPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}

	@Bean
	public UserDetailsService customerUserDetailsService() {
		return new CustomerUserDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider customerAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customerUserDetailsService());
		authProvider.setPasswordEncoder(customerPasswordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain customerSecurityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		http.authenticationProvider(customerAuthenticationProvider());
		
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				auth -> auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers(mvc.pattern("/customer/**")).authenticated()
						.requestMatchers(mvc.pattern("/**")).permitAll())
				.formLogin((form) -> form.loginPage("/Login").usernameParameter("email").passwordParameter("password")
						.loginProcessingUrl("/Login").successForwardUrl("/login_success_handler")
						.failureForwardUrl("/login_failure_handler").permitAll())
				.logout((logout) -> logout.invalidateHttpSession(true).clearAuthentication(true)
						.deleteCookies("JSESSIONID").permitAll());

		return http.build();
	}
}
