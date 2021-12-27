package com.vti.backend.DataLayer;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

/**
 * This class is Account Repository Interface
 * 
 * @Description: 
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public interface IAccountRepository {
	/**
	 * This method is get list account
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public List<Account> getListAccounts() throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is get account by account id
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public Account getAccountsById(int id) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check username exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param userName
	 * @return username exists: true / username not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception 
	 */
	public boolean isAccountUserNameExists(String userName) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check email exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param email
	 * @return email exists: true / email not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isAccountEmailExists(String email) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check account id exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @return account id exists: true / account id not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is create account
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param gender
	 * @param department_id
	 * @param position_id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int createAccount(String email, String userName, String fullName, String gender, byte department_id, byte position_id, Date sqlCreateDate) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is update account
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param gender
	 * @param departmentId
	 * @param positionId
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateAccount(int id, String email, String userName, String fullName, String gender, byte departmentId, byte positionId) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is delete account
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteAccount(int id) throws SQLException, ClassNotFoundException, Exception;	
}
