package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Position.PositionName;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {

	public String convertToDatabaseColumn(PositionName name) {
		if (name == null) {
			return null;
		}
		return name.getName();
	}

	public PositionName convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return Position.PositionName.toEnum(sqlStatus);
	}

}
