package com.hdq.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdq.dto.AccountDTO;
import com.hdq.dto.DepartmentDTO;
import com.hdq.entity.Department;
import com.hdq.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/department")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IDepartmentService service;
	
	@GetMapping()
	public List<DepartmentDTO> getAllDepartments(){
		List<Department> entities = service.getAllDepartments();
		// convert entities --> dtos
				List<DepartmentDTO> dtos = modelMapper.map(entities, new TypeToken<List<DepartmentDTO>>() {
				}.getType());
				
				return dtos;
	}
	
	
}
