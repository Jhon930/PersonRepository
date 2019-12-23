package com.project.client.utils;

import java.util.List;

import com.project.client.model.Persona;

public class PersonaMapper {
	
	public static Persona map(List<Persona> personas) {
		Persona persona = new Persona();
		for (Persona p : personas) {
			if (p.getAccounts() != null) persona.setAccounts(p.getAccounts());
			if (p.getName() != null) persona.setName(p.getName());
			if (p.getLastName() != null) persona.setLastName(p.getLastName());
			if (p.getDni() != null) persona.setDni(p.getDni());	
			if (p.getAddress() != null) persona.setAddress(p.getAddress());
			if (p.getPhoneNumber() != null) persona.setPhoneNumber(p.getPhoneNumber());
			if (p.getMobilePhoneNumber() != null) persona.setMobilePhoneNumber(p.getMobilePhoneNumber());
			if (p.getPersonType() != null) persona.setPersonType(p.getPersonType());
		}
		return persona;
	}

}
