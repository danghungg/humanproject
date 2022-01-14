package com.hdq.service;

import java.util.List;
import com.hdq.entity.Project;
import com.hdq.form.project.CreatePrjectForm;
import com.hdq.form.project.UppdateProjectForm;

public interface IProjectService {
	public List<Project> getAllProject();

	public Project getProjectByName(String name);

	public void createProject(CreatePrjectForm form);

	public void updateProject(UppdateProjectForm form);

	public boolean isProjectExistsByName(String name);

	public boolean isProjectExistsByID(int id);

	public Project getProjectByID(int id);

	public void deleteProject(short id);
}
