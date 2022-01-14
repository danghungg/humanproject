package com.hdq.form.account;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAccountForm {
	private String name;
	
	private String gender;
	
	private short age;
	
	private String knowledge;
	
	private short expYears;
}
