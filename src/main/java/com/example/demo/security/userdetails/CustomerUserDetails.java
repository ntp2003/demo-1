package com.example.demo.security.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.CustomerAccount;

import lombok.Getter;
import lombok.Setter;

public class CustomerUserDetails implements UserDetails{
	@Getter
	@Setter
	private CustomerAccount customerAccount;
	
	public CustomerUserDetails(com.example.demo.model.CustomerAccount customerAccount) {
		this.customerAccount = new CustomerAccount(customerAccount);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_CUSTOMER");  
        authorities.add(authority); 
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customerAccount.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customerAccount.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
