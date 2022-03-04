package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.DetailDepartment;
import com.vti.respository.IDetailDepartmentRespository;

@Service
public class DetailDepartmentService implements IDetailDepartmentService {
	
	@Autowired
	private IDetailDepartmentRespository detailDepartmentRepository;

	@Override
	public Page<DetailDepartment> getAllDetailDepartments(Pageable pageable) {
		
		return detailDepartmentRepository.findAll(pageable);
	}

	@Override
	public DetailDepartment getDetailDepartmentByID(short id) {
		
		return detailDepartmentRepository.findById(id).get();
	}

	@Override
	public void createDetailDepartment(DetailDepartment detailDepartment) {
		
		detailDepartmentRepository.save(detailDepartment);		
	}

	@Override
	public void updateDetailDepartment(DetailDepartment detailDepartment) {
		detailDepartmentRepository.save(detailDepartment);
	}

	@Override
	public void deleteDetailDepartment(short id) {
		
		detailDepartmentRepository.deleteById(id);;
	}

	@Override
	public boolean isDetailDepartmentExistsByID(short id) {
		
		return detailDepartmentRepository.existsById(id);
	}
	
	
}
