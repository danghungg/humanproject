package com.hdq.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Project")
@Data
@RequiredArgsConstructor
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "projectName",length = 100, nullable = false,unique = true)
	private String name;
	
	@OneToMany(mappedBy = "projectid", cascade = CascadeType.REMOVE)
	private List<Account> accounts;
}
