package com.vti.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.DetailDepartment;

public interface IDetailDepartmentRespository extends JpaRepository<DetailDepartment, Short> {

}
