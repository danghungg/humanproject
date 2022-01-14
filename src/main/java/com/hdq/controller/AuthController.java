package com.hdq.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdq.dto.LoginDTO;
import com.hdq.entity.Account;
import com.hdq.service.IAccountService;


@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountService service;

	@GetMapping("/login")
	public LoginDTO login(Principal principal) {

		String username = principal.getName();
		Account entity = service.getAccountByName(username);

		// convert entity --> dto
		LoginDTO dto = modelMapper.map(entity, LoginDTO.class);

		return dto;
	}
}
