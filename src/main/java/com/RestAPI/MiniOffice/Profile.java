package com.RestAPI.MiniOffice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private String name;
	private String contact;
	private String address;
	
	
	
	public Profile() {
		
	}
	public Profile(String name, String contact, String address) {
		this.name = name;
		this.contact = contact;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
