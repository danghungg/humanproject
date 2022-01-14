package com.hdq.form.project;

import java.util.List;




import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreatePrjectForm {
	private String name;
	private List<Account> accounts;

	@Data
	@NoArgsConstructor
	public static class Account {
		private int id;
		
	}
}
