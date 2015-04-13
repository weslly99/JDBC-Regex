package br.com.weslly.exemple.test;

import java.time.LocalDate;

import br.com.weslly.exemple.dao.AddressDAO;
import br.com.weslly.exemple.dao.ContactDAO;
import br.com.weslly.exemple.dao.PeopleDAO;
import br.com.weslly.exemple.model.Address;
import br.com.weslly.exemple.model.People;

public class PeopleDAOTest {
	public static void main(String[] args) {
		AddressDAO addressdao = new AddressDAO();
		
		People people1 = new People();
		people1.setName("Pokemon");
		people1.setLastName("Lindemberg");
		people1.setBirth(LocalDate.of(1992, 10,10));
		people1.setCPF("001.044.943-12");
		people1.setMaritalStatus("solteiro");
		people1.setRG("0207523503308");
		people1.setGender('M');
		people1.setContact(new ContactDAO().list(4));
		people1.setAddress(addressdao.list(4));
		
		
		People people2 = new People();
		people2.setId(14);
		people2.setName("Digimon");
		people2.setLastName("Lindemberg");
		people2.setBirth(LocalDate.of(1992, 10,10));
		people2.setCPF("031.044.943-12");
		people2.setMaritalStatus("solteiro");
		people2.setRG("0205523500833");
		people2.setGender('M');
		people2.setContact(new ContactDAO().list(4));
		people2.setAddress(addressdao.list(4));
		
		PeopleDAO dao = new PeopleDAO();
		//dao.add(people1);
		/*dao.update(people2);
		dao.remove(16);*/
		
		System.out.println(dao.listAll());
		
	}
}
