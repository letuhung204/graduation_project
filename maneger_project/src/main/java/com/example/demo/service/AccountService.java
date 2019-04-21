package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService{
	Account findAccountByEmail(String email);
	Account saveAccount(Account account);
}
