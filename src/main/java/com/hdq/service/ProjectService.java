package com.hdq.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.hdq.entity.Account;
import com.hdq.entity.Department;
import com.hdq.entity.Project;
import com.hdq.form.project.CreatePrjectForm;
import com.hdq.form.project.UppdateProjectForm;
import com.hdq.repository.IAccountRepository;
import com.hdq.repository.IDepartmentRepository;
import com.hdq.repository.IProjectRepository;

@Service
@Transactional
public class ProjectService implements IProjectService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IProjectRepository repository;

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public List<Project> getAllProject() {

		return repository.findAll();
	}

	@Override
	public Project getProjectByName(String name) {
		// TODO Auto-generated method stub
		return repository.getProjectByName(name);
	}

	@Override
	public void createProject(@RequestBody CreatePrjectForm form) {
		// convert form to entity
		Project projectEntity = modelMapper.map(form, Project.class);

		// create project
		Project project = repository.save(projectEntity);

		// create accounts
		List<Account> accountEntities = projectEntity.getAccounts();
		for (Account account : accountEntities) {
			account=accountRepository.getById(account.getId());
			account.setProjectid(project);
			accountRepository.save(account);
		}
		

	}

	@Override
	public void updateProject(UppdateProjectForm form) {
		// convert form to entity
		Project projectEntity = modelMapper.map(form, Project.class);
		repository.save(projectEntity);
		

	}

	@Override
	public boolean isProjectExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProjectExistsByID(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	@Override
	public Project getProjectByID(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void deleteProject(short id) {
		repository.deleteProjectById(id);;

	}

}
