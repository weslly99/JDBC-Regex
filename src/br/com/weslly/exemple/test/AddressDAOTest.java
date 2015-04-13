package br.com.weslly.exemple.test;

import br.com.weslly.exemple.dao.AddressDAO;
import br.com.weslly.exemple.dao.GenericDAO;
import br.com.weslly.exemple.model.Address;

public class AddressDAOTest {
	public static void main(String[] args) {
		Address address = new Address();
		address.setUF("CE");
		address.setCity("Juazeiro");
		address.setStreet("Maria Aurora");
		address.setDistrict("Novo");
		address.setNumber("42A");
		
		Address address1 = new Address();
		address1.setId(5);
		address1.setUF("CE");
		address1.setCity("Juazeiro");
		address1.setStreet("Teste");
		address1.setDistrict("Outro Novo");
		address1.setNumber("428A");
		
		GenericDAO dao = new AddressDAO();
	/*	dao.add(address);
		dao.update(address1);*/
		System.out.println(dao.listAll());
		
	}
}
