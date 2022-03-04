package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	
	@GetMapping()
	public Page<Department> getAllDepartments(Pageable pageable){
		return departmentService.getAllDepartments(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Department getDepartmentById(@PathVariable(name = "id") short id) {
		return departmentService.getDepartmentByID(id);
	}
	
	@GetMapping(value = "/name")
	public Department getDepartmentByName(@RequestParam(name = "name") String name) {
		return departmentService.getDepartmentByName(name);
	}
	
	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		departmentService.createDepartment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") short id, @RequestBody Department department) {
		department.setId(id);
		departmentService.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		departmentService.deleteDepartment(id);
	}
}
