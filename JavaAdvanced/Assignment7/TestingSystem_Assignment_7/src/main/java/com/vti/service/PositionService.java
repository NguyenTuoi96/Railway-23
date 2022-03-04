package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.respository.IPositionRespository;

@Service
public class PositionService implements IPositionService {
	
	@Autowired
	private IPositionRespository positionRepository;

	@Override
	public Page<Position> getAllPositions(Pageable pageable) {
		
		return positionRepository.findAll(pageable);
	}

	@Override
	public Position getPositionByID(short id) {
		
		return positionRepository.findById(id).get();
	}

	@Override
	public Position getPositionByName(String name) {

		return positionRepository.findByPositionName(name);
	}

	@Override
	public void createPosition(Position position) {
		
		positionRepository.save(position);		
	}

	@Override
	public void updatePosition(Position position) {
		positionRepository.save(position);
	}

	@Override
	public void deletePosition(short id) {
		
		positionRepository.deleteById(id);;
	}

	@Override
	public boolean isPositionExistsByID(short id) {
		
		return positionRepository.existsById(id);
	}

	@Override
	public boolean isPositionExistsByName(String name) {
		Position position = getPositionByName(name);

		if (position == null) {
			return false;
		}
		return true;
	}
	
	
}
