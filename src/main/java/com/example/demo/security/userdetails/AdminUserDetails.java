package com.example.demo.security.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.Admin;

import lombok.Getter;
import lombok.Setter;

public class AdminUserDetails implements UserDetails{
	@Getter
	@Setter
	private Admin admin;
	
	public AdminUserDetails(com.example.demo.model.Admin admin) {
		this.admin = new Admin(admin);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");  
        authorities.add(authority);
        if(admin.isCreator())
        	authorities.add(new SimpleGrantedAuthority("ROLE_CREATOR"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
