package com.hdq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hdq.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {

	public Project getProjectByName(String name);
	public void deleteProjectById(short id);
}
