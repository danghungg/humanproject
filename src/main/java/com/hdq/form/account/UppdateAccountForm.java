package com.hdq.form.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UppdateAccountForm {
	private int id;

	private String name;

	private String gender;

	private short age;

	private String knowledge;

	private short expYears;
}
