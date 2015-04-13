package br.com.weslly.exemple.test;

import java.time.LocalDate;

import br.com.weslly.exemple.model.Address;
import br.com.weslly.exemple.model.Contact;
import br.com.weslly.exemple.model.People;

public class PeopleTest {
	
	public static void main(String[] args) {
		Address address = new Address();
		address.setUF("CE");
		address.setCity("Juazeiro");
		address.setStreet("Maria da conceição");
		address.setDistrict("São Jorge");
		address.setNumber("428AA");
		
		Contact contato = new Contact();
		contato.setEmail("Axe@hotmail.com");
		contato.setPhone("(88)98888-8888");
		
		People people1 = new People();
		people1.setName("Pokemon");
		people1.setLastName("Lindemberg");
		people1.setBirth(LocalDate.of(1992, 10,10));
		people1.setCPF("01.044.943-12");
		people1.setMaritalStatus("solteiro");
		people1.setRG("0207j5235008");
		people1.setGender('M');
		people1.setContact(contato);
		people1.setAddress(address);
		
		System.out.println(people1);
		
	}
}
