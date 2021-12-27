package com.vti.backend.BusinessLayer.Iplm;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vti.ConstantPack;
import com.vti.backend.BusinessLayer.IAccountService;
import com.vti.backend.DataLayer.IAccountRepository;
import com.vti.backend.DataLayer.Iplm.IplmAccountRepository;
import com.vti.entity.Account;

/**
 * This class is Account Service Implements
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class IplmAccountService implements IAccountService {
	private IAccountRepository accRepository;
	SimpleDateFormat simpleDateFormat;

	public IplmAccountService() {
		accRepository = new IplmAccountRepository();
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, Exception {
		return accRepository.getListAccounts();
	}

	@Override
	public Account getAccountsById(int id) throws SQLException, ClassNotFoundException, Exception {
		return accRepository.getAccountsById(id);
	}

	@Override
	public boolean isAccountUserNameExists(String userName) throws SQLException, ClassNotFoundException, Exception {
		return accRepository.isAccountUserNameExists(userName);
	}

	@Override
	public boolean isAccountEmailExists(String email) throws SQLException, ClassNotFoundException, Exception {
		return accRepository.isAccountEmailExists(email);
	}

	@Override
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException, Exception {
		return accRepository.isAccountIdExists(id);
	}

	@Override
	public void createAccount(String email, String userName, String fullName, String gender, byte department_id,
			byte position_id) throws SQLException, ClassNotFoundException, Exception {

		String formattedDate = simpleDateFormat.format(new Date());
		java.sql.Date sqlCreateDate = java.sql.Date.valueOf(formattedDate);
		int effectedRecordAmount = accRepository.createAccount(email, userName, fullName, gender, department_id, position_id, sqlCreateDate);
		if(effectedRecordAmount > 0) {
			System.out.printf(ConstantPack.INFO_INSERT_SUCCESS, effectedRecordAmount);
		}
	}

	@Override
	public void updateAccount(int id, String email, String userName, String fullName, String gender, byte departmentId,
			byte positionId) throws SQLException, ClassNotFoundException, Exception {
		int effectedRecordAmount = accRepository.updateAccount(id, email, userName, fullName, gender, departmentId, positionId);
		System.out.printf(ConstantPack.INFO_UPDATE_SUCCESS, effectedRecordAmount);
	}

	@Override
	public void deleteAccount(int id) throws SQLException, ClassNotFoundException, Exception {
		int effectedRecordAmount = accRepository.deleteAccount(id);
		System.out.printf(ConstantPack.INFO_DELETE_SUCCESS, effectedRecordAmount);
	}
}
