package com.vti.backend.DataLayer.Iplm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUtils;
import com.vti.backend.DataLayer.IAccountRepository;
import com.vti.backend.DataLayer.IGroupRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;

/**
 * This class is 
 * 
 * @Description: 
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class IplmGroupRepository implements IGroupRepository {

	@Override
	public boolean isGroupIdExists(byte id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Group getGroupById(byte id) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> getListGroupInAccount(byte id) throws SQLException, ClassNotFoundException, Exception {
		try {
			List<Group> list = new ArrayList<Group>();
			String sql = "SELECT g.* FROM `group` g INNER JOIN group_account ga ON ga.group_id = g.group_id WHERE ga.account_id = ?;";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Lấy acc
			IAccountRepository accRes = new IplmAccountRepository();
			while (resultSet.next()) {

				Account acc = accRes.getAccountsById((byte) resultSet.getInt("creator_id"));
				
				list.add(new Group((byte) resultSet.getInt("group_id"), resultSet.getString("group_name"), acc,
						resultSet.getDate("create_date"), null));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
