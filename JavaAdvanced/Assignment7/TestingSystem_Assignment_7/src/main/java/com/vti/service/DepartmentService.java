package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.respository.IDepartmentRespository;

@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private IDepartmentRespository departmentRepository;

	@Override
	public Page<Department> getAllDepartments(Pageable pageable) {
		
		return departmentRepository.findAll(pageable);
	}

	@Override
	public Department getDepartmentByID(short id) {
		
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {

		return departmentRepository.findByName(name);
	}

	@Override
	public void createDepartment(Department department) {
		
		departmentRepository.save(department);		
	}

	@Override
	public void updateDepartment(short id, String newName) {
		Department department = new Department(id, newName);
		departmentRepository.save(department);	
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		
		departmentRepository.deleteById(id);;
	}

	@Override
	public boolean isDepartmentExistsByID(short id) {
		
		return departmentRepository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}
	
	
}
