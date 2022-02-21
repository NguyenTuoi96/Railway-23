package com.vti.frontend;

import java.util.List;

import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRepository;

public class DetailDepartmentProgram {
	public static void main(String[] args) {
		DetailDepartmentRepository repository = new DetailDepartmentRepository();
		
		System.out.println("\n\n***********CREATE DETAIL DEPARTMENT***********");

		DetailDepartment departmentDetailCre = new DetailDepartment();
		departmentDetailCre.setDepartmentName("department test");
		departmentDetailCre.setEmulationPoint((short) 12);
		repository.createDetailDepartment(departmentDetailCre);

		System.out.println("***********GET ALL DETAIL DEPARTMENT***********");

		List<DetailDepartment> detailDepartmentList = repository.getAllDetailDepartments();

		for (DetailDepartment detailDepartment : detailDepartmentList) {
			System.out.println(detailDepartment);
		}

	}
}
