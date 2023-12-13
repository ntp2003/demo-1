// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String cccd;
	private boolean creator;

	public Admin(com.example.demo.model.Admin admin) {
		this.username = admin.getUsername();
		this.password = admin.getPassword();
		String name = admin.getFullName();
		if (name.split("\\w+").length > 1) {
			this.lastName = name.substring(name.lastIndexOf(" ") + 1);
			this.firstName = name.substring(0, name.lastIndexOf(' '));
		} else {
			this.firstName = name;
		}
		this.phoneNumber = admin.getPhoneNumber();
		this.email = admin.getEmail();
		this.cccd = admin.getCccd();
		this.creator = admin.getCreator();
	}
	
	public com.example.demo.model.Admin toModel() {
		com.example.demo.model.Admin admin = new com.example.demo.model.Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setFullName(firstName + " " + lastName);
		admin.setPhoneNumber(phoneNumber);
		admin.setEmail(email);
		admin.setCccd(cccd);
		admin.setCreator(creator);
		return admin;
	}
}
