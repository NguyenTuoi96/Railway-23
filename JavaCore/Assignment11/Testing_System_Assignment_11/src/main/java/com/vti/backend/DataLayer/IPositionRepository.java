package com.vti.backend.DataLayer;

import java.sql.SQLException;

import com.vti.entity.Position;

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
public interface IPositionRepository {
	/**
	 * This method is check position id exists
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
	 */
	public boolean isPositionIdExists(byte id) throws SQLException, ClassNotFoundException;
	
	/**
	 * This method is get position by id
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
	public Position getPositionById(byte id) throws SQLException, ClassNotFoundException,Exception;
}
