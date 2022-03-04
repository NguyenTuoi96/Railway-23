package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Position;

public interface IPositionService {
	public Page<Position> getAllPositions(Pageable pageable);
	
	public Position getPositionByID(short id);
	
	public Position getPositionByName(String name);
	
	public void createPosition(Position position);
	
	public void updatePosition(Position position);
	
	public void deletePosition(short id);
	
	public boolean isPositionExistsByID(short id);
	
	public boolean isPositionExistsByName(String name);
}
