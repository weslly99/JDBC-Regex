package br.com.weslly.exemple.test;

import java.util.Arrays;

import br.com.weslly.exemple.dao.ContactDAO;
import br.com.weslly.exemple.model.Contact;

public class ContactDAOTest {

	public static void main(String[] args) {
		
		ContactDAO contactDAO = new ContactDAO();
		
		Contact contato = new Contact();
		contato.setEmail("bomberman9@hotmail.com");
		contato.setPhone("(88)8888-8888");
		
		Contact contato1 = new Contact();
		contato1.setId(21);
		contato1.setEmail("ad99@hotmail.com");
		contato1.setPhone("(77)97777-7777");
		
		contactDAO.add(contato);
		contactDAO.update(contato1);
		System.out.println(contactDAO.list(21));
		contactDAO.remove(21);
		
		//System.out.println(contactDAO.listAll());
			
	}
}
