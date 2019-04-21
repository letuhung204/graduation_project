package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Account findAccountByEmail(String email) {
		// TODO Auto-generated method stub
		return accountRepo.findAccountByEmail(email);
	}

	@Override
	public Account saveAccount(Account account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		account.setEnabled(true);
		Role accountRole = roleRepo.findByName("ADMIN");
		account.setRoleSet(new HashSet<Role>(Arrays.asList(accountRole)));
		return accountRepo.save(account);
	}

}
