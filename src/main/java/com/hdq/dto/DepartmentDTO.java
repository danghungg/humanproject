package com.hdq.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DepartmentDTO {
	private short id;
	private String name;
//	private List<AccountDTO> accounts;

//@Data
//@NoArgsConstructor
//static class AccountDTO {
//	@JsonProperty("accountId")
//	private int id;
//
//	private String username;
//}
}