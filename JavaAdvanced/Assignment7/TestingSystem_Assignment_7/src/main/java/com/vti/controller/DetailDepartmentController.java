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
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.DetailDepartment;
import com.vti.service.IDetailDepartmentService;

@RestController
@RequestMapping(value = "api/v1/detailDepartments")
public class DetailDepartmentController {
	@Autowired
	private IDetailDepartmentService detailDepartmentService;
	
	@GetMapping()
	public Page<DetailDepartment> getAllDetailDepartments(Pageable pageable){
		return detailDepartmentService.getAllDetailDepartments(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public DetailDepartment getDetailDepartmentById(@PathVariable(name = "id") short id) {
		return detailDepartmentService.getDetailDepartmentByID(id);
	}
	
	@PostMapping()
	public void createDetailDepartment(@RequestBody DetailDepartment detailDepartment) {
		detailDepartmentService.createDetailDepartment(detailDepartment);
	}

	@PutMapping(value = "/{id}")
	public void updateDetailDepartment(@PathVariable(name = "id") short id, @RequestBody DetailDepartment detailDepartment) {
		detailDepartment.setId(id);
		detailDepartmentService.updateDetailDepartment(detailDepartment);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDetailDepartment(@PathVariable(name = "id") short id) {
		detailDepartmentService.deleteDetailDepartment(id);
	}
}
