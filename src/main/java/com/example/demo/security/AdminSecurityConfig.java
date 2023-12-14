package com.example.demo.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.example.demo.handler.CustomAccessDeniedHandler;
import com.example.demo.handler.CustomLogoutSuccessHandler;
import com.example.demo.service.AdminUserDetailsService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig {
	@Bean
	public PasswordEncoder adminPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public UserDetailsService adminUserDetailsService() {
        return new AdminUserDetailsService();
    }
	
	@Bean
    public DaoAuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminUserDetailsService());
        authProvider.setPasswordEncoder(adminPasswordEncoder());
        return authProvider;
    }
	
	@Bean
	@Order(1)
	public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		http.authenticationProvider(adminAuthenticationProvider());
		
		http.csrf(csrf -> csrf.disable()).securityMatcher("/admin/**")
				.authorizeHttpRequests(
						auth -> auth
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers(mvc.pattern("/admin/creator/**")).hasRole("CREATOR")
						.anyRequest().hasRole("ADMIN"))
				.formLogin((form) -> form.loginPage("/admin/Login")
						.loginProcessingUrl("/admin/Login")
						.successForwardUrl("/admin/login_success_handler")
						.failureForwardUrl("/admin/login_failure_handler")
						.permitAll())
				.logout((logout) -> logout.logoutUrl("/admin/logout").invalidateHttpSession(true).clearAuthentication(true)
						.deleteCookies("JSESSIONID").logoutSuccessHandler(new CustomLogoutSuccessHandler()).permitAll())
				.exceptionHandling(ex -> ex.accessDeniedHandler(new CustomAccessDeniedHandler("/admin/Login")))
				;

		return http.build();
	}
}
