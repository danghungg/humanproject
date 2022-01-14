package com.hdq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdq.entity.Account;
import com.hdq.entity.Department;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

	public Account getAccountByName(String name);
	Account findByUserName(String userName);
}

