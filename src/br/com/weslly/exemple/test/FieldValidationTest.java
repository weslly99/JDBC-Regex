package br.com.weslly.exemple.test;

import java.time.LocalDate;
import javax.xml.ws.soap.AddressingFeature;
import br.com.weslly.exemple.model.Address;
import br.com.weslly.exemple.util.AddressFieldValidation;
import br.com.weslly.exemple.util.ContactFieldValidation;
import br.com.weslly.exemple.util.PeopleFieldValidation;

public class FieldValidationTest {
	public static void main(String[] args) {
		System.out.println(PeopleFieldValidation.RGValidate("2007029011807"));
		System.out.println(PeopleFieldValidation.CPFValidate("045.084.983-02"));
		System.out.println(PeopleFieldValidation.maritalStatusValidate("Casado"));
		System.out.println(PeopleFieldValidation.generValidate('M'));
		System.out.println(PeopleFieldValidation.birthValidate(LocalDate.of(1992,10,10)));		
		System.out.println(AddressFieldValidation.cityValidation("Juazeiro do Norte"));
		System.out.println(AddressFieldValidation.numberValidation("42345A"));
		System.out.println(ContactFieldValidation.phoneValidation("(88)8887-2858"));
		System.out.println(ContactFieldValidation.emailValidation("weslly@hotmail.com.br"));
		
	}
}

