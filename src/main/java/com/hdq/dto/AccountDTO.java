package com.hdq.dto;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountDTO {
	private short id;
	private String name;
	private String gender;
	private short  age;
	private String knowledge;
	private short expYears;
	
}
