package com.example.demo.handler;

import java.io.IOException;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLogoutSuccessHandler  implements LogoutSuccessHandler{
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpStatus.OK.value());
	    response.sendRedirect(request.getHeader("referer"));
	}
}
