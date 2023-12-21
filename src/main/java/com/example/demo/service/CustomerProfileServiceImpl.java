package com.example.demo.service;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerAccount;
import com.example.demo.model.ElectronicWallet;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ElectronicWalletRepo;
import com.example.demo.security.userdetails.CustomerUserDetails;
import com.example.demo.util.Converter;
import com.example.demo.util.FirebaseUtil;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{
	@Autowired
	@Qualifier("customerPasswordEncoder")
	private PasswordEncoder customerPasswordEncoder;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ElectronicWalletRepo electronicWalletRepo;
	
	@Override
	public boolean chekcPassword(String password, CustomerAccount current) {
		return customerPasswordEncoder.matches(password, current.getPassword());
	}

	@Override
	public CustomerUserDetails updateInformation(CustomerAccount newInfo, int accountId) {
		return customerRepo.findById(accountId).map(i -> {
			i.setCustomerName(newInfo.getFirstName() + " " + newInfo.getLastName());
			i.setAddress(newInfo.getAddress());
			i.setPhoneNumber(newInfo.getPhoneNumber());
			i.setBirthDate(newInfo.getBirthDate());
			return new CustomerUserDetails(customerRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));
	}

	@Override
	public CustomerUserDetails updatePassword(String newPassword, int accountId) {
		return customerRepo.findById(accountId).map(i -> {
			i.setPassword(customerPasswordEncoder.encode(newPassword));
			return new CustomerUserDetails(customerRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));
	}

	@Override
	public CustomerUserDetails updateAvatar(String avatar, int accountId) {
		return customerRepo.findById(accountId).map(i -> {
			try {
				i.setAvatar(FirebaseUtil.Upload(Converter.DataURLImagetoFile(avatar)));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeErrorException(null, "Upload image failed !!!");
			}
			return new CustomerUserDetails(customerRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));
	}

	@Override
	public CustomerUserDetails linkElectronicWallet(int walletId, String verificationCodes, int accountId) {
		Optional<ElectronicWallet> electronicWallet = electronicWalletRepo.findById(walletId);
		if(electronicWallet.isEmpty())
			throw new IllegalArgumentException("Wallet not found !!!");
		if(electronicWallet.get().getVerificationCodes().equals(verificationCodes))
			return customerRepo.findById(accountId).map(i -> {
				i.setElectronicWallet(electronicWallet.get());
				return new CustomerUserDetails(customerRepo.save(i));
			}).orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));
		throw new IllegalArgumentException("Verification code is not correct !!!");
	}

	@Override
	public CustomerUserDetails unlinkElectronicWallet(int accountId) {
		return customerRepo.findById(accountId).map(i -> {
			i.setElectronicWallet(null);
			return new CustomerUserDetails(customerRepo.save(i));
		}).orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));
	}

}
