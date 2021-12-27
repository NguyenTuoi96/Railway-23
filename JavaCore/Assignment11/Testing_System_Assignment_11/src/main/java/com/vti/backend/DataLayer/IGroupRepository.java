package com.vti.backend.DataLayer;

import java.sql.SQLException;
import java.util.List;

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
public interface IGroupRepository {
	public boolean isGroupIdExists(byte id) throws SQLException, ClassNotFoundException;
	public Group getGroupById(byte id) throws SQLException, ClassNotFoundException,Exception;
	public List<Group> getListGroupInAccount(byte id) throws SQLException, ClassNotFoundException, Exception;
}
