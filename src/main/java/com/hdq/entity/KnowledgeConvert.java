package com.hdq.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class KnowledgeConvert implements AttributeConverter<Account.Knowledge, String> {

	@Override
	public String convertToDatabaseColumn(Account.Knowledge type) {
		if (type == null) {
			return null;
		}

		return type.getValue();
	}

	@Override
	public Account.Knowledge convertToEntityAttribute(String sqlValue) {
		if (sqlValue == null) {
			return null;
		}

		return Account.Knowledge.toEnum(sqlValue);
	}

}
