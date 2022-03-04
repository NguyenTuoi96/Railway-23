package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Salary;

public interface ISalaryService {
	public Page<Salary> getAllSalarys(Pageable pageable);
	
	public Salary getSalaryByID(short id);
	
	public Salary getSalaryByName(String name);
	
	public void createSalary(Salary salary);
	
	public void updateSalary(Salary salary);
	
	public void deleteSalary(short id);
	
	public boolean isSalaryExistsByID(short id);
	
	public boolean isSalaryExistsByName(String name);
}
