package com.project.client.model;

public class Account {
	
	private String id;
	private String numberAccount;
	private float currentBalance;
	private String  createdAt;
	private String typeAccount;
	
	private Persona person;
	
	public Persona getPerson() {
		return person;
	}
	public void setPerson(Persona person) {
		this.person = person;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}
	public float getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getTypeAccount() {
		return typeAccount;
	}
	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", numberAccount=" + numberAccount + ", currentBalance=" + currentBalance + "]";
	}
	
	
	

}
