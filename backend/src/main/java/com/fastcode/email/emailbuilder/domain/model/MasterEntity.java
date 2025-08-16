package com.fastcode.email.emailbuilder.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_entity")
public class MasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(name = "master_name" , length = 256)
	private String masterName;
	
	@Basic
	@Column(name = "master_value" , length = 256)
	private String masterValue;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMasterName() {
		return masterName;
	}


	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}


	public String getMasterValue() {
		return masterValue;
	}


	public void setMasterValue(String masterValue) {
		this.masterValue = masterValue;
	}
	
	
}

