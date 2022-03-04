package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Salary;
import com.vti.respository.ISalaryRespository;

@Service
public class SalaryService implements ISalaryService {
	
	@Autowired
	private ISalaryRespository salaryRepository;

	@Override
	public Page<Salary> getAllSalarys(Pageable pageable) {
		
		return salaryRepository.findAll(pageable);
	}

	@Override
	public Salary getSalaryByID(short id) {
		
		return salaryRepository.findById(id).get();
	}

	@Override
	public Salary getSalaryByName(String name) {

		return salaryRepository.findBySalaryName(name);
	}

	@Override
	public void createSalary(Salary salary) {
		
		salaryRepository.save(salary);		
	}

	@Override
	public void updateSalary(Salary salary) {
		salaryRepository.save(salary);
	}

	@Override
	public void deleteSalary(short id) {
		
		salaryRepository.deleteById(id);;
	}

	@Override
	public boolean isSalaryExistsByID(short id) {
		
		return salaryRepository.existsById(id);
	}

	@Override
	public boolean isSalaryExistsByName(String name) {
		Salary salary = getSalaryByName(name);

		if (salary == null) {
			return false;
		}
		return true;
	}
	
	
}
