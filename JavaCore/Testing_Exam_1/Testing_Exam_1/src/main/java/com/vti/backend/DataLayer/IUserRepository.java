package com.vti.backend.DataLayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

/**
 * This class is User Repository Interface
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public interface IUserRepository {
	
	/**
	 * This method is get list user
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @return list user
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public List<User> getListInfoUsers() throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is get user by id
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param id
	 * @return user
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public User getUsersById(int id) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is getUsersByEmailAndPassWord
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 29, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 29, 2021
	 * @param email
	 * @param password
	 * @return User
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public User getUsersByEmailAndPassWord(String email, String password) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check email id exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param email
	 * @return email id exists: true / email id not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public boolean isUserEmailExists(String email) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check user id exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param id
	 * @return user id exists: true / user id not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is check password id exists
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param password
	 * @return password id exists: true / password id not exists: false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public boolean isUserPasswordExists(String password) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is create user
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param fullname
	 * @param email
	 * @param password
	 * @param expInYear
	 * @param proSkill
	 * @param userType
	 * @return effected RecordAmount
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int createUser(String fullname, String email, String password, Byte expInYear, String proSkill, byte userType) throws SQLException, ClassNotFoundException, Exception;
	
	/**
	 * This method is delete user
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param id
	 * @return effected RecordAmount
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int deleteUser(int id) throws SQLException, ClassNotFoundException, Exception;
}
