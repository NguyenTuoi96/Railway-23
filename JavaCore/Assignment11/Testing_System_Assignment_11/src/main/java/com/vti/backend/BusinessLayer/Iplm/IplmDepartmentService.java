package com.vti.backend.BusinessLayer.Iplm;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.BusinessLayer.IDepartmentService;
import com.vti.backend.DataLayer.IDepartmentRepository;
import com.vti.backend.DataLayer.Iplm.IplmDepartmentRepository;
import com.vti.entity.Department;

/**
 * This class is Department Service Implements
 * 
 * @Description: 
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class IplmDepartmentService implements IDepartmentService {
	private IDepartmentRepository departmentRepository;
	public IplmDepartmentService() {
		departmentRepository = new IplmDepartmentRepository();
	}
	
	@Override
	public List<Department> getDepartments() throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.getDepartments();
	}
	
	@Override
	public Department getDepartmentsById(byte id) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.getDepartmentsById(id);
	}
	
	@Override
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.isDepartmentNameExists(name);
	}
	
	@Override
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.isDepartmentIdExists(id);
	}
	
	@Override
	public int createDepartment(String name) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.createDepartment(name);
	}
	
	@Override
	public int updateDepartment(int id, String name) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.updateDepartment(id, name);
	}
	
	@Override
	public int deleteDepartment(int id) throws SQLException, ClassNotFoundException, Exception {
		return departmentRepository.deleteDepartment(id);
	}
	
}
