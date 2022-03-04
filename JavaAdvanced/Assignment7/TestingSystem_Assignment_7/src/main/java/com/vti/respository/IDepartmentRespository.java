package com.vti.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yaml.snakeyaml.events.Event.ID;

import com.vti.entity.Department;

public interface IDepartmentRespository extends JpaRepository<Department, Short> {

	public List<Department> findAll();

	public Department findByName(String name);

	// @Queryannotation
	@Query("SELECT d FROM Department d")
	public List<Department> getAllDepartments();
	
	@Query("SELECT d FROM Department d WHERE id = :idParam")
	public Department getDepartmentByID(@Param("idParam") Short id);
	
	@Query("SELECT d FROM Department d WHERE name = :nameParam")
	public Department getDepartmentByName(@Param("nameParam") String name);
	
//	@Modifying
//	@Query("INSERT INTO Department(name, totalMember) SELECT :nameParam, :totalMemberParam FROM Dual")
//	public int createDepartment(@Param("nameParam") String name, @Param("totalMemberParam") Short totalMember);
	
	@Modifying
	@Query("UPDATE Department d SET d.name = :nameParam, d.totalMember = :totalMemberParam WHERE d.id = :id")
	public void updateDepartment(@Param("id") Short id, @Param("nameParam") String name, @Param("totalMemberParam") Short totalMember);
	
	@Modifying
	@Query("DELETE FROM Department d WHERE id = :idParameter")
	public void deleteDepartment(@Param("idParameter") Short id);
}
