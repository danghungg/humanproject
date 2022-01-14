package com.hdq.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdq.dto.AccountDTO;
import com.hdq.entity.Account;
import com.hdq.form.account.CreateAccountForm;
import com.hdq.form.account.UppdateAccountForm;
import com.hdq.form.project.CreatePrjectForm;
import com.hdq.form.project.UppdateProjectForm;
import com.hdq.service.AccountService;
import com.hdq.service.IAccountService;


@RestController
@RequestMapping(value = "api/v1/account")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IAccountService service;
	
	@GetMapping()
	public List<AccountDTO> getAllAccount(){
		List<Account> entities = service.getAllAccount();

		// convert entities --> dtos
		List<AccountDTO> dtos = modelMapper.map(entities, new TypeToken<List<AccountDTO>>() {
		}.getType());
		
		return dtos;

	}
	@PostMapping()
	public void createAccount(@RequestBody CreateAccountForm form) {
		service.createAccount(form);
	}
	
	@PutMapping(value = "/{id}")
	public void updateAccount(
			@PathVariable(name = "id") int id, 
			@RequestBody UppdateAccountForm form) {
		form.setId(id);
		service.updateAccount(form);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id) {
		service.deleteAccountByID(id);
	}
}
