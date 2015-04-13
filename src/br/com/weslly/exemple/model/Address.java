package br.com.weslly.exemple.model;

import br.com.weslly.exemple.util.AddressFieldValidation;

public class Address {
	private long id;
	private String UF;
	private String city;
	private String district;
	private String street;
	private String number;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		if(!AddressFieldValidation.UFValidation(uF)){
			System.out.printf("%25s\n","UF invalida!");
			return;
		}
		this.UF = uF;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(!AddressFieldValidation.cityValidation(city)){
			System.out.printf("%25s\n","Cidade invalida!");
			return;
		}
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		if(!AddressFieldValidation.districtValidation(district)){
			System.out.printf("%25s\n","Bairro invalido!");
			return;
		}
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		if(!AddressFieldValidation.streetValidation(street)){
			System.out.printf("%25s\n","Rua invalida!");
			return;
		}
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number){
		if(!AddressFieldValidation.numberValidation(number)){
			System.out.printf("%25s\n","Numero invalido!");
			return;
		}
		this.number = number;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(40);
		builder.append(String.format("Endereço:\n[UF: %s\nCidade: %s\n"
				+ "Bairro: %s\nRua: %s\nNumber: %s]\n",
				UF,city,district,street,number));
		
		return builder.toString();
	}
}
