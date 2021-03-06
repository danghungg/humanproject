package com.hdq.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdq.entity.Account;
import com.hdq.entity.Project;
import com.hdq.form.account.CreateAccountForm;
import com.hdq.form.account.UppdateAccountForm;
import com.hdq.repository.IAccountRepository;

@Service
@Transactional
public class AccountService implements IAccountService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IAccountRepository repository;

	@Override
	public List<Account> getAllAccount() {
		return repository.findAll();
	}

	@Override
	public Account getAccountByName(String name) {
		
		return repository.findByUserName(name);
	}

	@Override
	public void createAccount(CreateAccountForm form) {

		// convert form to entity
		Account accountEntity = modelMapper.map(form, Account.class);
		repository.save(accountEntity);
	}

	@Override
	public void updateAccount(UppdateAccountForm form) {
		Account accountEntity = modelMapper.map(form, Account.class);
		repository.save(accountEntity);

	}

	@Override
	public boolean isAccountExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountByID(int id) {

		return repository.getById(id);
	}

	@Override
	public void deleteAccountByID(int id) {
		repository.deleteById(id);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repository.findByUserName(username);

		if (account == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(
				account.getUserName(), 
				account.getPassWord(), 
				AuthorityUtils.createAuthorityList(account.getRole().toString()));
		
	}

}
