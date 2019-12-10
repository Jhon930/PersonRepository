package com.project.client.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Info person", description = "Complete data of a entity Persona")
@Document(collection="persons")
public class Persona {
	
	@Id
	@ApiModelProperty(value = "The id of the info", required = false)
	private String id;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String name;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String lastName;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String dni;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String address;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String phoneNumber;
	private String mobilePhoneNumber;
	@ApiModelProperty(value = "The id of the info", required = true)
	private String personType;
	
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
	
	
	
}
