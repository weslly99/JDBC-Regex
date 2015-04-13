package br.com.weslly.exemple.model;

import java.time.LocalDate;
import java.util.regex.Pattern;

import br.com.weslly.exemple.util.PeopleFieldValidation;

public class People {
	private long id;
	private String name;
	private String lastName;
	private String CPF;
	private String RG;
	private String maritalStatus;
	private char gender;
	private LocalDate birth;
	private Address address;
	private Contact contact;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(!PeopleFieldValidation.nameValidate(name)){
			System.out.printf("%25s\n","Nome invalido!");
			return;
		}
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(!PeopleFieldValidation.nameValidate(lastName)){
			System.out.printf("%25s\n","Sobrenome invalido!");
			return;
		}
		this.lastName = lastName;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cpf) {
		if(!PeopleFieldValidation.CPFValidate(cpf)){
			System.out.printf("%25s\n","CPF invalido!");
			return;
		}
		
		this.CPF = cpf;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rg) {
		if(!PeopleFieldValidation.RGValidate(rg)){
			System.out.printf("%25s\n","RG invalido!");
			return;
		}
		RG = rg;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		if(!PeopleFieldValidation.maritalStatusValidate(maritalStatus)){
			System.out.printf("%25s\n","Estado Civil invalido!");
			return;
		}
		this.maritalStatus = maritalStatus;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		if(!PeopleFieldValidation.generValidate(gender)){
			System.out.printf("%25s\n","Genero invalido!");
			return;
		}
		this.gender = gender;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		if(!PeopleFieldValidation.birthValidate(birth)){
			System.out.printf("%25s\n","Nascimento invalido!");
			return;
		}
		this.birth = birth;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(40);
		builder.append(String.format("Pessoa:\n[Nome: %s\nSobrenome: %s\nCPF: %s\n"
				+ "RG: %s\nEstado Civil: %s\nGenero: %s\nNascimento: %d/%d/%d\n%s\n%s]\n",
				this.name,
				this.lastName,
				this.CPF,
				this.RG,
				this.maritalStatus,
				this.gender,
				this.birth.getDayOfMonth(),
				this.birth.getMonth().ordinal(),
				this.birth.getYear(),
				this.address,
				this.contact));
		
		return builder.toString();
	}
	
	
}
