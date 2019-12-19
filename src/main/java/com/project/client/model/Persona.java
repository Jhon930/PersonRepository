package com.project.client.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Document(collection="persons")
public class Persona {
	
	@Id
	private String id;

	private String name;

	private String lastName;
	
	private String dni;
	
	private String address;

	private String phoneNumber;
	
	private String mobilePhoneNumber;
	
	private String personType;

	@Transient
	private List<Account> accounts;
	
	public Persona() {
		
	}
	
	public Persona(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Persona(String id, String name, String lastName, String dni, String address, String phoneNumber,
			String mobilePhoneNumber, String personType) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.personType = personType;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobileNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", accounts=" + accounts +"]";
	}

	
	
}
