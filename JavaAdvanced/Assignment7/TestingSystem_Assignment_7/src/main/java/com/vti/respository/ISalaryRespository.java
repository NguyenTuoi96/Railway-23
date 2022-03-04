package com.vti.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Salary;
import com.vti.entity.Salary.SalaryName;

public interface ISalaryRespository extends JpaRepository<Salary, Short> {

	public List<Salary> findAll();

	public Salary findBySalaryId(Short id);

	public Salary findBySalaryName(String name);

	// @Queryannotation
	@Query("SELECT s FROM Salary s")
	public List<Salary> getAllSalarys();

	@Query("SELECT s FROM Salary s WHERE s.salaryId = :idParam")
	public Salary getSalaryByID(@Param("idParam") Short id);

	@Query("SELECT s FROM Salary s WHERE s.salaryName = :nameParam")
	public Salary getSalaryByName(@Param("nameParam") SalaryName name);

//	@Modifying
//	@Query("INSERT INTO Salary(salaryName) SELECT :nameParam FROM DUAL")
//	public void createSalary(@Param("nameParam") SalaryName name);

	@Modifying
	@Query("UPDATE Salary s SET s.salaryName = :nameParam WHERE s.salaryId = :id")
	public void updateSalary(@Param("id") Short id, @Param("nameParam") SalaryName name);

	@Modifying
	@Query("DELETE FROM Salary s WHERE s.salaryId = :idParameter")
	public void deleteSalary(@Param("idParameter") Short id);
}
