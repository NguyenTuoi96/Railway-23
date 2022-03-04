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

import com.vti.entity.Salary;
import com.vti.service.ISalaryService;

@RestController
@RequestMapping(value = "api/v1/salarys")
public class SalaryController {
	@Autowired
	private ISalaryService salaryService;
	
	@GetMapping()
	public Page<Salary> getAllSalarys(Pageable pageable){
		return salaryService.getAllSalarys(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Salary getSalaryById(@PathVariable(name = "id") short id) {
		return salaryService.getSalaryByID(id);
	}
	
	@GetMapping(value = "/name")
	public Salary getSalaryByName(@RequestParam(name = "name") String name) {
		return salaryService.getSalaryByName(name);
	}
	
	@PostMapping()
	public void createSalary(@RequestBody Salary salary) {
		salaryService.createSalary(salary);
	}

	@PutMapping(value = "/{id}")
	public void updateSalary(@PathVariable(name = "id") short id, @RequestBody Salary salary) {
		salary.setSalaryId(id);
		salaryService.updateSalary(salary);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteSalary(@PathVariable(name = "id") short id) {
		salaryService.deleteSalary(id);
	}
}
