package br.com.weslly.exemple.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class PeopleFieldValidation {
	
	public static boolean nameValidate(String name){
		return Pattern.matches("[A-Za-zçãáé' ]*", name);
	}
	public static boolean CPFValidate(String cpf){
		return Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", cpf);
	}
	public static boolean RGValidate(String rg){
		return Pattern.matches("[0-9]{13}",rg);
	}
	public static boolean maritalStatusValidate(String maritalStatus){
		return Pattern.matches("((c|C)asado)|((s|S)olteiro)", maritalStatus);
	}
	public static boolean generValidate(char gender){
		return Pattern.matches("[MmFf]{1}",String.valueOf(gender));
	}
	public static boolean birthValidate(LocalDate birth){
		Period period = Period.between(birth, LocalDate.now());
		return period.getYears() >= 18 ? true : false;
	}
	
}
