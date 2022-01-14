package com.hdq.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "`Account`")
@Data
@RequiredArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "`name`", length = 100, nullable = false)
	private String name;

	@Column(name = "sex", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "age", nullable = false)
	private short age;

	@Column(name = "knowledge", nullable = false)
	private Knowledge knowledge;

	@Column(name = "expYears", nullable = false)
	private short expYears;

	@ManyToOne()
	@JoinColumn(name = "departmentId",referencedColumnName = "id" )
	private Department departmentid;
	
	@ManyToOne()
	@JoinColumn(name = "projectId",referencedColumnName = "id" )
	private Project projectid;
	
	public enum Gender {
		MALE,FEMALE,UNKOWN
	}

	
	public enum Knowledge {
		ANGULAR("angular"), REACTJC("reactjs"), ECLIPSE("eclipse"), SP("Spring boot");

		private String value;

		private Knowledge(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static Knowledge toEnum(String sqlValue) {
			for (Knowledge knowledge : Knowledge.values()) {
				if (knowledge.getValue().equals(sqlValue)) {
					return knowledge;
				}
			}
			return null;
		}

	}

}
