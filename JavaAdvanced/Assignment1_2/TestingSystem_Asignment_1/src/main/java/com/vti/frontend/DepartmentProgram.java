package com.vti.frontend;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		System.out.println("\n\n***********CREATE DEPARTMENT***********");

		Department departmentCre = new Department();
		departmentCre.setDepartmentName("department test 1");
		repository.createDepartment(departmentCre);

		System.out.println("***********GET ALL DEPARTMENT***********");

		List<Department> departmentList = repository.getAllDepartments();

		for (Department department : departmentList) {
			System.out.println(department);
		}

	}
}
