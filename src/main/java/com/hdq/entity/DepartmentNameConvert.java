package com.hdq.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentNameConvert implements AttributeConverter<Department.DepartmentName, String> {

	@Override
	public String convertToDatabaseColumn(Department.DepartmentName name) {
		if (name == null) {
			return null;
		}

		return name.getValue();
	}

	@Override
	public Department.DepartmentName convertToEntityAttribute(String sqlValue) {
		if (sqlValue == null) {
			return null;
		}

		return Department.DepartmentName.toEnum(sqlValue);
	}

}
