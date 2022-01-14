package com.hdq.service;

import java.util.List;

import com.hdq.entity.Department;


public interface IDepartmentService {

	public List<Department> getAllDepartments();

	public Department getDepartmentByName(String name);

	public void createDepartment();

	public void updateDepartment();

	public boolean isDepartmentExistsByName(String name);

	public boolean isDepartmentExistsByID(int id);

	public Department getDepartmentByID(int id);

	public void deleteDepartment(int id);
}
