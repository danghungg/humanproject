package com.hdq.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdq.entity.Account;
import com.hdq.entity.Department;

import com.hdq.repository.IAccountRepository;
import com.hdq.repository.IDepartmentRepository;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IDepartmentRepository repository;
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public List<Department> getAllDepartments() {

		return repository.findAll();
	}

	@Override
	public Department getDepartmentByName(String name) {

		return repository.getDepartmentByName(name);
	}

	@Override
	public void createDepartment() {
	}

	@Override
	public void updateDepartment() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		
	}

	

}
