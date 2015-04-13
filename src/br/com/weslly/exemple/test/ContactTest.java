package br.com.weslly.exemple.test;

import br.com.weslly.exemple.model.Contact;


public class ContactTest {
		
	public static void main(String[] args) {
		Contact contato = new Contact();
		contato.setEmail("pacman9@hotmail.com");
		contato.setPhone("(88)8888-8888");
		System.out.println(contato);
	}
	
}
