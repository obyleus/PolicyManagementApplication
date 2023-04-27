package com.obyleus.policymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_type")
public class PolicyType {
	
	@Id
	@JoinColumn(name = "policy_type_id")
	private int id;
	
	
	@Column(name = "policy_type_name")
	private String policyTypeName;
	
	public PolicyType( ) {
		
	}

	public PolicyType(int id, String policyTypeName) {
		super();
		this.id = id;
		this.policyTypeName = policyTypeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyTypeName() {
		return policyTypeName;
	}

	public void setPolicyTypeName(String policyTypeName) {
		this.policyTypeName = policyTypeName;
	}
	
	
}
