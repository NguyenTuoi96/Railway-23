package com.vti.backend.DataLayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

/**
 * This class is Department Repository Interface
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public interface IDepartmentRepository {
	/**
	 * This method is get department
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @return List Department
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Department> getDepartments() throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is get department by id
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @return Department
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public Department getDepartmentsById(byte id) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is check department name exists
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param name
	 * @return department name exists: true / department name not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is check department id exists
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @return department id exists: true / department id not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is create department
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param name
	 * @return affected recordamount
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int createDepartment(String name) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is update department
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @param name
	 * @return affected recordamount
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int updateDepartment(int id, String name) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * This method is
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @return affected recordamount
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int deleteDepartment(int id) throws SQLException, ClassNotFoundException, Exception;
}
