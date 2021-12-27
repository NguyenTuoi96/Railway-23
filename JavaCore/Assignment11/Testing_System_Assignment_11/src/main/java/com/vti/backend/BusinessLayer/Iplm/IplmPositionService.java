package com.vti.backend.BusinessLayer.Iplm;

import java.sql.SQLException;

import com.vti.backend.BusinessLayer.IPositionService;
import com.vti.backend.DataLayer.IPositionRepository;
import com.vti.backend.DataLayer.Iplm.IplmPositionRepository;
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
public class IplmPositionService implements IPositionService {
	private IPositionRepository positionRepository;
	public IplmPositionService() {
		positionRepository = new IplmPositionRepository();
	}

	@Override
	public boolean isPositionIdExists(byte id) throws SQLException, ClassNotFoundException {
		return positionRepository.isPositionIdExists(id);
	}

	@Override
	public Position getPositionById(byte id) throws SQLException, ClassNotFoundException, Exception {
		return positionRepository.getPositionById(id);
	}
}
