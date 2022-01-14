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

import com.hdq.dto.DepartmentDTO;
import com.hdq.dto.ProjectDTO;
import com.hdq.entity.Department;
import com.hdq.entity.Project;
import com.hdq.form.project.CreatePrjectForm;
import com.hdq.form.project.UppdateProjectForm;
import com.hdq.service.IProjectService;

@RestController
@RequestMapping(value = "api/v1/project")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProjectController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IProjectService service;

	@GetMapping()
	public List<ProjectDTO> getAllProject() {
		List<Project> entities = service.getAllProject();
		// convert entities --> dtos
				List<ProjectDTO> dtos = modelMapper.map(entities, new TypeToken<List<ProjectDTO>>() {
				}.getType());
				
				return dtos;
	}
	@PostMapping()
	public void createProject(@RequestBody CreatePrjectForm form) {
		service.createProject(form);
	}
	
	@PutMapping(value = "/{id}")
	public void updateDepartment(
			@PathVariable(name = "id") short id, 
			@RequestBody UppdateProjectForm form) {
		form.setId(id);
		service.updateProject(form);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteProject(@PathVariable(name = "id") short id) {
		service.deleteProject(id);
	}

}
