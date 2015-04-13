package br.com.weslly.exemple.test;

import br.com.weslly.exemple.model.Address;

public class AddressTest {
	
	public static void main(String[] args) {
		Address address = new Address();
		address.setUF("CE");
		address.setCity("Juazeiro");
		address.setStreet("São Pedro");
		address.setDistrict("N Teste");
		address.setNumber("422");
		System.out.println(address);
	}
}
