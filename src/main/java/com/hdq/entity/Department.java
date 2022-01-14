package com.hdq.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Department")
@Data
@RequiredArgsConstructor
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "departmentName", nullable = false)
	@Convert(converter = DepartmentNameConvert.class)
	private DepartmentName name;

	@OneToMany(mappedBy = "departmentid")
	private List<Account> accounts;
	
	
	
	// cấu hình enum
	
	public enum DepartmentName {
		DEV("Development"), HR("HR"), BUSINESS("Kinh doanh"), ACCOUNTANT("Kế Toán");

		private String value;

		private DepartmentName(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static DepartmentName toEnum(String sqlValue) {
			for (DepartmentName name : DepartmentName.values()) {
				if (name.getValue().equals(sqlValue)) {
					return name;
				}
			}
			return null;
		}

	}
}
