package com.bridgeit.addressbook.service;


public interface AddressBookInter {
	
	public void addPerson();
	
	public void getFullName();
	
	public void removePerson(int index);
	
	public void updatePerson();
	
	public void sortByName();
	
	public void sortByZipcode();
	
	public void display();
	
	public void display(String name);
}	
