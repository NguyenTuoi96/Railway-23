package com.vti.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Position;

public interface IPositionRespository extends JpaRepository<Position, Short> {

	public List<Position> findAll();

	public Position findByPositionName(Short id);

	public Position findByPositionName(String name);

	// @Queryannotation
	@Query("SELECT p FROM Position p")
	public List<Position> getAllPositions();

	@Query("SELECT p FROM Position p WHERE p.positionId = :idParam")
	public Position getPositionByID(@Param("idParam") Short id);

	@Query("SELECT p FROM Position p WHERE p.positionName = :nameParam")
	public Position getPositionByName(@Param("nameParam") PositionName name);

//	@Modifying
//	@Query("INSERT INTO Position(positionName) SELECT :nameParam FROM DUAL")
//	public void createPosition(@Param("nameParam") PositionName name);

	@Modifying
	@Query("UPDATE Position p SET p.positionName = :nameParam WHERE p.positionId = :id")
	public void updatePosition(@Param("id") Short id, @Param("nameParam") PositionName name);

	@Modifying
	@Query("DELETE FROM Position p WHERE p.positionId = :idParameter")
	public void deletePosition(@Param("idParameter") Short id);

}
