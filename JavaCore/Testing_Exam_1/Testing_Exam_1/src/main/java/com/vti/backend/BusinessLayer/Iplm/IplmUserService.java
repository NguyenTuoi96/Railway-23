package com.vti.backend.BusinessLayer.Iplm;

import java.sql.SQLException;
import java.util.List;

import com.vti.ConstantPack;
import com.vti.backend.BusinessLayer.IUserService;
import com.vti.backend.DataLayer.IUserRepository;
import com.vti.backend.DataLayer.Iplm.IplmUserRepository;
import com.vti.entity.User;

/**
 * This class is User Service Implements
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class IplmUserService implements IUserService {
	private IUserRepository userRepository;

	public IplmUserService() {
		userRepository = new IplmUserRepository();
	}

	@Override
	public List<User> getListInfoUsers() throws ClassNotFoundException, SQLException, Exception {
		return userRepository.getListInfoUsers();
	}

	@Override
	public User getUsersById(int id) throws SQLException, ClassNotFoundException, Exception {
		return userRepository.getUsersById(id);
	}

	@Override
	public User getUsersByEmailAndPassWord(String email, String password) throws SQLException, ClassNotFoundException, Exception {
		return userRepository.getUsersByEmailAndPassWord(email, password);
	}

	@Override
	public boolean isUserEmailExists(String email) throws SQLException, ClassNotFoundException, Exception {
		return userRepository.isUserEmailExists(email);
	}

	@Override
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException, Exception {
		return userRepository.isUserIdExists(id);
	}

	@Override
	public boolean isUserPasswordExists(String password) throws SQLException, ClassNotFoundException, Exception {
		return userRepository.isUserPasswordExists(password);
	}

	@Override
	public void createUser(String fullname, String email) throws SQLException, ClassNotFoundException, Exception {
		int effectedRecordAmount = userRepository.createUser(fullname, email, "123456", null, null, ConstantPack.CONSTANT_USER_TYPE_EMPLOYEE);
		if(effectedRecordAmount > 0) {
			System.out.printf(ConstantPack.INFO_INSERT_SUCCESS, effectedRecordAmount);
		}
	}

	@Override
	public void deleteUser(int id) throws SQLException, ClassNotFoundException, Exception {
		int effectedRecordAmount = userRepository.deleteUser(id);
		System.out.printf(ConstantPack.INFO_DELETE_SUCCESS, effectedRecordAmount);
	}
}
