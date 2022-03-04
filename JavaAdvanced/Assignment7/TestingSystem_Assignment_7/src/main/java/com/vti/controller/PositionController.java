package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Position;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "api/v1/positions")
public class PositionController {
	@Autowired
	private IPositionService positionService;
	
	@GetMapping()
	public Page<Position> getAllPositions(Pageable pageable){
		return positionService.getAllPositions(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Position getPositionById(@PathVariable(name = "id") short id) {
		return positionService.getPositionByID(id);
	}
	
	@GetMapping(value = "/name")
	public Position getPositionByName(@RequestParam(name = "name") String name) {
		return positionService.getPositionByName(name);
	}
	
	@PostMapping()
	public void createPosition(@RequestBody Position position) {
		positionService.createPosition(position);
	}

	@PutMapping(value = "/{id}")
	public void updatePosition(@PathVariable(name = "id") short id, @RequestBody Position position) {
		position.setPositionId(id);
		positionService.updatePosition(position);
	}

	@DeleteMapping(value = "/{id}")
	public void deletePosition(@PathVariable(name = "id") short id) {
		positionService.deletePosition(id);
	}
}
