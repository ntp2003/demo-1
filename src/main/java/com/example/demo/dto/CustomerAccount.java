// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount implements Serializable {
	private int accountId;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String address = "{\"city\":\"\",\"district\":\"\",\"ward\":\"\",\"detail\":\"\"}";
	private String phoneNumber;
	private String email;
	private String avatar;
	private ElectronicWallet electronicWallet;

	public CustomerAccount(com.example.demo.model.CustomerAccount customerAccount) {
		this.accountId = customerAccount.getAccountId();
		this.password = customerAccount.getPassword();
		String name = customerAccount.getCustomerName();
		if (name.split("\\w+").length > 1) {
			this.lastName = name.substring(name.lastIndexOf(" ") + 1);
			this.firstName = name.substring(0, name.lastIndexOf(' '));
		} else {
			this.firstName = name;
		}
		this.birthDate = customerAccount.getBirthDate();
		if (customerAccount.getAddress() != null && !customerAccount.getAddress().isBlank())
			this.address = customerAccount.getAddress();
		this.phoneNumber = customerAccount.getPhoneNumber();
		this.email = customerAccount.getEmail();
		this.avatar = customerAccount.getAvatar();
		if (customerAccount.getElectronicWallet() != null)
			this.electronicWallet = new ElectronicWallet(customerAccount.getElectronicWallet());
	}

	public com.example.demo.model.CustomerAccount toModel() {
		com.example.demo.model.CustomerAccount customerAccount = new com.example.demo.model.CustomerAccount();

		customerAccount.setAccountId(accountId);
		customerAccount.setPassword(password);
		customerAccount.setCustomerName(firstName + " " + lastName);
		customerAccount.setBirthDate(birthDate);
		customerAccount.setAddress(address);
		customerAccount.setPhoneNumber(phoneNumber);
		customerAccount.setEmail(email);
		customerAccount.setAvatar(avatar);

		if (electronicWallet != null)
			customerAccount.setElectronicWallet(electronicWallet.toModel());

		return customerAccount;
	}
}
