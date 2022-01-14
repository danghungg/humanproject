package com.hdq.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hdq.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
	
	public Department getDepartmentByName(String name);

}
