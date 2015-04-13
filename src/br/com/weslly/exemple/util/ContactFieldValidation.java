package br.com.weslly.exemple.util;

import java.util.regex.Pattern;

public class ContactFieldValidation {

	public static boolean phoneValidation(String phone){
		return Pattern.matches("\\(\\d{2}\\)((\\d{4}|\\d{5})\\-\\d{4})",phone);
	}
	public static boolean emailValidation(String email){
		return Pattern.matches("[a-z_0-9].+@[a-z].+",email);
	}
}
