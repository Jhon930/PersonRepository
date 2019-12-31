package com.project.client.utils;

import java.util.List;

import com.project.client.model.Person;

public class PersonaMapper {
	
	public static Person map(List<Person> persons) {
		Person person = new Person();
		for (Person p : persons) {
			if (p.getAccounts() != null) person.setAccounts(p.getAccounts());
			if (p.getName() != null) person.setName(p.getName());
			if (p.getLastName() != null) person.setLastName(p.getLastName());
			if (p.getDni() != null) person.setDni(p.getDni());	
			if (p.getAddress() != null) person.setAddress(p.getAddress());
			if (p.getPhoneNumber() != null) person.setPhoneNumber(p.getPhoneNumber());
			if (p.getMobilePhoneNumber() != null) person.setMobilePhoneNumber(p.getMobilePhoneNumber());
		}
		return person;
	}

}
