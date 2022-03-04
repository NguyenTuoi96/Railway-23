package com.vti.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Salary;

public interface IAccountRespository extends JpaRepository<Account, Short> {

	public List<Account> findAll();

	public Account findByAccountId(Short id);

	public Account findByUsername(String name);

	// @Queryannotation
	@Query("SELECT a FROM Account a")
	public List<Account> getAllAccounts();

	@Query("SELECT a FROM Account a WHERE a.accountId = :idParam")
	public Account getAccountByID(@Param("idParam") Short id);

	@Query("SELECT a FROM Account a WHERE a.username = :nameParam")
	public Account getAccountByName(@Param("nameParam") String name);

//	@Modifying
//	@Query("INSERT INTO Account(email, username, firstName, lastName, department, position, salary) "
//			+ "SELECT :email, :username, :firstName, :lastName, :department, :position, :salary FROM DUAL")
//	public void createAccount(@Param("email") String email, @Param("username") String username,
//			@Param("firstName") String firstName, @Param("lastName") String lastName,
//			@Param("department") Department department, @Param("position") Position position,
//			@Param("salary") Salary salary);

	@Modifying
	@Query("UPDATE Account a SET email = :email" + ", username = :username" + ", firstName = :firstName"
			+ ", lastName = :lastName" + ", department = :department" + ", position = :position" + ", salary = :salary "
			+ "WHERE a.accountId = :id")
	public void updateAccount(@Param("id") Short id, @Param("email") String email, @Param("username") String username,
			@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("department") Department department, @Param("position") Position position,
			@Param("salary") Salary salary);

	@Modifying
	@Query("DELETE FROM Account a WHERE accountId = :id")
	public void deleteDepartment(@Param("id") Short id);
}
