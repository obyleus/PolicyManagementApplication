package com.obyleus.policymanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "policy_number")
	private int policyNumber;
	
	@JoinColumn(name = "policy_type_name")
	@Column(name = "policy_type_id")
	private int policyTypeId;
	
	@Column(name = "policy_premium")
	private int policyPremium;
	
	@Column(name = "policy_status")
	private String policyStatus;
	
	@Column(name = "policy_create_user")
	private String policyCreateUser;
	
	@Column(name = "policy_create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date policyCreateDate;
	
	@Column(name = "policy_update_user")
	private String policyUpdateUser;
	
	@Column(name = "policy_update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date policyUpdateDate;
	
	@Column(name = "customer_number")
	private Integer customerNumber;
	
	public Policy() {
		
	}

	public Policy(int policyNumber, int policyTypeId, int policyPremium, String policyStatus, String policyCreateUser,
			Date policyCreateDate, String policyUpdateUser, Date policyUpdateDate, int customerNumber) {
		super();
		this.policyNumber = policyNumber;
		this.policyTypeId = policyTypeId;
		this.policyPremium = policyPremium;
		this.policyStatus = policyStatus;
		this.policyCreateUser = policyCreateUser;
		this.policyCreateDate = policyCreateDate;
		this.policyUpdateUser = policyUpdateUser;
		this.policyUpdateDate = policyUpdateDate;
		this.customerNumber = customerNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public int getPolicyTypeId() {
		return policyTypeId;
	}

	public void setPolicyTypeId(int policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public int getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(int policyPremium) {
		this.policyPremium = policyPremium;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getPolicyCreateUser() {
		return policyCreateUser;
	}

	public void setPolicyCreateUser(String policyCreateUser) {
		this.policyCreateUser = policyCreateUser;
	}

	public Date getPolicyCreateDate() {
		return policyCreateDate;
	}

	public void setPolicyCreateDate(Date policyCreateDate) {
		this.policyCreateDate = policyCreateDate;
	}

	public String getPolicyUpdateUser() {
		return policyUpdateUser;
	}

	public void setPolicyUpdateUser(String policyUpdateUser) {
		this.policyUpdateUser = policyUpdateUser;
	}

	public Date getPolicyUpdateDate() {
		return policyUpdateDate;
	}

	public void setPolicyUpdateDate(Date policyUpdateDate) {
		this.policyUpdateDate = policyUpdateDate;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	
	
}
