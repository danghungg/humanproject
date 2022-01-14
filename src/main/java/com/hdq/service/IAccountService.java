package com.hdq.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hdq.entity.Account;
import com.hdq.form.account.CreateAccountForm;
import com.hdq.form.account.UppdateAccountForm;


public interface IAccountService extends UserDetailsService{

	public List<Account> getAllAccount();

	public Account getAccountByName(String name);

	public void createAccount(CreateAccountForm form);

	public void updateAccount(UppdateAccountForm form);

	public boolean isAccountExistsByName(String name);

	public boolean isAccountExistsByID(int id);

	public Account getAccountByID(int id);

	public void deleteAccountByID(int id);
}
