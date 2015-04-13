package br.com.weslly.exemple.util;

import java.util.regex.Pattern;

public class AddressFieldValidation {

	public static boolean UFValidation(String uf){
		return Pattern.matches("[A-Z]{2}", uf);
	}
	public static boolean cityValidation(String city){
		return Pattern.matches("[\\wÁÀãÉáàéíç].+",city);
	}
	public static boolean districtValidation(String district){
		return Pattern.matches("[\\wÁÀãÉáàéíç].+",district);
	}
	public static boolean streetValidation(String street){
		return Pattern.matches("[\\wÁÀãÉáàéíç].+", street);
	}
	public static boolean numberValidation(String number){
		return Pattern.matches("[\\d]+[A-Za-z]?", number);
	}
	
}
