package com.vti.backend.DataLayer.Iplm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.Utils.JdbcUtils;
import com.vti.backend.DataLayer.IPositionRepository;
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
public class IplmPositionRepository implements IPositionRepository {
	public boolean isPositionIdExists(byte id) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM position WHERE position_id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public Position getPositionById(byte id) throws SQLException, ClassNotFoundException,Exception {
		try {

			String sql = "SELECT * FROM position WHERE position_id = " + id + ";";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			if (resultSet.next() == true) {
				Position position = new Position((byte) resultSet.getInt(1), resultSet.getString(2));
				return position;
			} else {
				throw new Exception("Cannot find department which has id = " + id);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
