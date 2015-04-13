package br.com.weslly.exemple.model;

import br.com.weslly.exemple.util.ContactFieldValidation;

public class Contact {
	private long id;
	private String phone;
	private String email;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if(!ContactFieldValidation.phoneValidation(phone)){
			System.out.printf("%25s\n","Telefone invalido!");
			return;
		}
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!ContactFieldValidation.emailValidation(email)){
			System.out.printf("%25s\n","E-mail invalido!");
			return;
		}
		this.email = email;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Contato:\n[telefone: %s\nemail: %s]\n",
									this.phone,this.email));
		return builder.toString();
	}
}
