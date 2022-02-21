package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Salary.SalaryName;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String> {

	public String convertToDatabaseColumn(SalaryName salaryName) {
		if (salaryName == null) {
			return null;
		}
		return salaryName.getSalaryName();
	}

	public SalaryName convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return Salary.SalaryName.toEnum(sqlStatus);
	}

}
