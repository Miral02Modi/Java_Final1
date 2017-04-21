package com.bridgeit.addressbook.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.bridgeit.addressbook.model.Person;
import com.bridgeit.addressbook.model.Url;

public class AddressImple implements AddressBookInter {

	static Scanner scanner = new Scanner(System.in);
	HashMap<String, List> hashMap = new HashMap<>();
	List<Person> mainLinkedList = new LinkedList<>();

	/* Add data into specific address book */
	@Override
	public void addPerson() {

		Person personInfo = new Person();

		System.out.println("Enter the book name");
		String bookName = scanner.next();
		System.out.print("Enter The Name firstName::");
		String name = scanner.next();
		personInfo.setFirstName(name);
		System.out.print("Enter The LastName::");
		personInfo.setLastName(scanner.next());

		System.out.print("Enter The Id::");
		if (scanner.hasNextInt()) {
			personInfo.setId(scanner.nextInt());
		} else {
			System.out.println("Enter the Integer type of data only");
			addPerson();
		}

		System.out.print("Eneter the Mobile Number::");
		long phone = 0;
		if (scanner.hasNextLong()) {
			phone = scanner.nextLong();
		} else {
			System.out.println("Enter the integer type of data only");
			addPerson();
		}

		String strPhone = "" + phone;
		if (mobileNumeberValidation(strPhone)) {

			personInfo.setPhone(phone);
			System.out.print("Enter The full Address::");
			Scanner scannerInput = new Scanner(System.in);
			personInfo.setAddress(scannerInput.nextLine());

			System.out.print("Enter the city Name::");
			personInfo.setCity(scanner.next());

			System.out.print("Enter The State Name::");
			personInfo.setState(scanner.next());

			System.out.print("Enter The ZipCode::");
			long zipCode = 0;
			if (scanner.hasNextLong()) {
				zipCode = scanner.nextLong();
			} else {
				System.out.println("Enter the integer type of data only");
				addPerson();
			}

			String strZipcode = "" + zipCode;
			personInfo.setZipCode(zipCode);

			if (zipCodeValidation(strZipcode)) {
				mainLinkedList.add(personInfo);
				if (hashMap.get(bookName) == null)
					hashMap.put(bookName, new LinkedList<>());
				hashMap.get(bookName).add(personInfo);
			} else
				System.out.println("Enter the valid ZipCode");
		} else
			System.out.println("Enter the valid mobile number");

		System.out.println(hashMap);
		HashMap<String, List> h1 = fileReader();

		if (h1 != null) {
			Set<String> keys = h1.keySet();
			String strKeys[] = new String[keys.size()];
			int index = 0;

			for (String str : keys) {
				System.out.println(str);
				strKeys[index++] = str;
			}

			for (int i = 0; i < strKeys.length; i++) {

				if (hashMap.containsKey(strKeys[i])) {
					LinkedList linkedList1 = (LinkedList) h1.get(strKeys[i]);
					linkedList1.addAll(mainLinkedList);
					hashMap.put(bookName, linkedList1);
				} else {
					LinkedList linkedList1 = (LinkedList) h1.get(strKeys[i]);
					hashMap.put(strKeys[i], linkedList1);
				}

			}
		}
		System.out.println("Data added successfully into the file");
		fileWriter();

		System.out.println(hashMap);

	}

	/* Zipcode validation */
	private boolean zipCodeValidation(String zipCode) {

		for (int i = 0; i < zipCode.length() && zipCode.length() == 6; i++) {
			if (zipCode.charAt(i) >= '0' && zipCode.charAt(i) <= '9')
				continue;
			else
				return false;
		}
		return zipCode.length() == 6;
	}

	// remove the person information from specific addressbook
	@Override
	public void removePerson(int index) {
		
		hashMap = fileReader();
		System.out.println("Enter The address Book Name");
		String bookName = scanner.next();
		LinkedList personArray = (LinkedList) hashMap.get(bookName);

		if (personArray != null && personArray.size() != 0) {
			try {
				personArray.remove(index - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Index is not present please enter valid index");
				removePerson(index);
			}
			hashMap.put(bookName, personArray);
			fileWriter();
			display();
		} else
			System.out.println("No data is avilable");
	}

	// Update data from specific adressBook
	@Override
	public void updatePerson() {
		
		
		hashMap = fileReader();
		System.out.println("Enter your bookName");
		LinkedList<Person> updateArray = (LinkedList<Person>) hashMap.get(scanner.next());
		System.out.println("Enter The Mobile Number");
		long srchPhone = 0;
		if (scanner.hasNextLong()) {
			srchPhone = scanner.nextLong();
		} else {
			System.out.println("Please enter the valid mobile number");
			updatePerson();
		}

		Person updatePerson = null;

		int k = 0;
		boolean flag = false, flag1 = false;
		if (updateArray != null) {
			for (k = 0; k < updateArray.size(); k++) {
				updatePerson = updateArray.get(k);
				long phone = updatePerson.getPhone();
				if (phone == srchPhone) {
					flag = true;
					break;
				}
			}

			if (flag) {
				for (int i = 0;; i++) {
					updatePerson = updateArray.get(k);

					System.out.println("1.firstName::");
					System.out.println("2.LastName::");
					System.out.println("3.Id::");
					System.out.println("4.Mobile Number::");
					System.out.println("5.full Address::");
					System.out.println("6.city Name::");
					System.out.println("7.State Name::");
					System.out.println("8.ZipCode::");
					System.out.println("9.Exit::");
					System.out.println("Enter The choice");
					String choice = scanner.next();

					switch (choice) {
					case "1":

						if (checkStatus()) {
							System.out.print("Enter the fistName::");
							updatePerson.setFirstName(scanner.next());
							System.out.println("Your data is updated");
						}
						break;
					case "2":

						if (checkStatus()) {
							System.out.print("Enter the LastName::");
							updatePerson.setLastName(scanner.next());
							System.out.println("Your data is updated");
						}

						break;
					case "3":
						if (checkStatus()) {
							System.out.print("Enter the Id::");
							if (scanner.hasNextInt()) {
								updatePerson.setId(scanner.nextInt());
								System.out.println("Your data is updated");

							} else {
								System.out.println("Enter only intger type of data");
								updatePerson();
							}
						}

					case "4":
						if (checkStatus()) {
							System.out.print("Enter the Mobile Number::");
							if (scanner.hasNextLong()) {
								updatePerson.setPhone(scanner.nextLong());
								System.out.println("Your data is updated");
							} else {
								System.out.println("Enter only intger type of data");
								updatePerson();
							}
						}
						break;
					case "5":

						Scanner scanner1 = new Scanner(System.in);
						System.out.print("Enter the address::");
						if (checkStatus()) {
							updatePerson.setAddress(scanner1.nextLine());
							System.out.println("Your data is updated");
						}
						break;

					case "6":

						if (checkStatus()) {
							System.out.print("Enter the City::");
							updatePerson.setCity(scanner.next());
							System.out.println("Your data is updated");
						}
						break;

					case "7":

						if (checkStatus()) {
							System.out.print("Enter the State::");
							updatePerson.setState(scanner.next());
							System.out.println("Your data is updated");
						}
						break;
					case "8":
						if (checkStatus()) {
							System.out.print("Enter the Zipcode::");
							if (scanner.hasNextLong()) {
								updatePerson.setZipCode(scanner.nextLong());
								System.out.println("Your data is updated");
							} else {
								System.out.println("Enter the integer value");
								updatePerson();
							}
						}
						break;
					case "9":
						flag1 = true;
						break;
					default:
						mainLinkedList.add(k, updatePerson);
						hashMap.put("Person_Information", mainLinkedList);
						System.out.println("Enter the valid choice");
						break;
					}
					if (flag1) {
						System.out.println(updatePerson);
						mainLinkedList.add(k, updatePerson);
						hashMap.put("Person_Information", mainLinkedList);
						fileWriter();
						return;
					}
				}
			} else
				System.out.println("Enter The valid data::");
		} else
			System.out.println("No data is avilable");
	}

	/* updating status chacking */
	boolean checkStatus() {
		System.out.println("Do you want to update or not");
		String status = scanner.next();

		if (status.equalsIgnoreCase("yes")) {
			return true;
		} else if (status.equalsIgnoreCase("yes"))
			return false;
		else {
			System.out.println("please enter" + (char) 34 + "yes" + (char) 34 + "or" + (char) 34 + "no" + (char) 34);
			checkStatus();
		}
		return false;
	}

	/* sorting the data by name from specific address book */
	@Override
	public void sortByName() {

		System.out.print("Enter The Name book Name");
		String book = scanner.next();
		hashMap = fileReader();
		LinkedList arrSort = (LinkedList) hashMap.get(book);

		if (arrSort != null  && !arrSort.isEmpty()) {
			LinkedList dataAdd = new LinkedList<>();
			for (int i = 0; arrSort.size() != 0; i++) {

				Person srtByName = (Person) arrSort.get(0);
				String name1 = srtByName.getFirstName();

				for (int j = 1; j < arrSort.size(); j++) {

					Person srtByNameTemp = (Person) arrSort.get(j);
					String name2 = srtByNameTemp.getFirstName();
					System.out.println(name2.compareTo(name1));
					if (name2.compareTo(name1) < 0) {
						srtByName = srtByNameTemp;
					}
				}

				System.out.println("Id is a::" + srtByName.getId());
				System.out.println("First Name::" + srtByName.getFirstName());
				System.out.println("Last Name::" + srtByName.getLastName());
				System.out.println("Phone Number is::" + srtByName.getPhone());
				System.out.println("Address::" + srtByName.getAddress());
				System.out.println("City::" + srtByName.getCity());
				System.out.println("State is::" + srtByName.getState());
				dataAdd.add(arrSort.remove(arrSort.indexOf(srtByName)));

			}
			hashMap.put(book, dataAdd);
		} else
			System.out.println("No data is found::");

	}

	/* sorting the data by zipCode from specific address book */
	@Override
	public void sortByZipcode() {

		System.out.print("Enter The Name book Name");
		String book = scanner.next();
		hashMap = fileReader();
		LinkedList arrSort = (LinkedList) hashMap.get(book);

		if (arrSort != null && !arrSort.isEmpty()) {
			List dataAdd = new LinkedList<>();
			for (int i = 0; arrSort.size() != 0; i++) {

				Person srtByZip = (Person) arrSort.get(0);
				long zip1 = srtByZip.getZipCode();

				for (int j = 1; j < arrSort.size(); j++) {

					Person srtByZipTemp = (Person) arrSort.get(j);
					long zip2 = srtByZipTemp.getZipCode();

					if (zip2 < zip1) {
						srtByZip = srtByZipTemp;
					}
				}

				System.out.println("zipcode is:" + srtByZip.getZipCode());
				System.out.println("Id is a::" + srtByZip.getId());
				System.out.println("First Name::" + srtByZip.getFirstName());
				System.out.println("Last Name::" + srtByZip.getLastName());
				System.out.println("Phone Number is::" + srtByZip.getPhone());
				System.out.println("Address::" + srtByZip.getAddress());
				System.out.println("City::" + srtByZip.getCity());
				System.out.println("State is::" + srtByZip.getState());

				dataAdd.add(arrSort.remove(arrSort.indexOf(srtByZip)));
			}
			hashMap.put(book, dataAdd);
		} else
			System.out.println("No data is found::");
	}

	/* getting full name from specific address userName */
	@Override
	public void getFullName() {

		System.out.println("Enter The your book Name");
		hashMap = fileReader();
		LinkedList personArray = (LinkedList) hashMap.get(scanner.next());

		if (personArray != null && !personArray.isEmpty()) {
			System.out.println("Enter your id::");
			for (int i = 0; i < personArray.size(); i++) {
				Person perInfo = (Person) personArray.get(i);
				int id = scanner.nextInt();
				int srchId = perInfo.getId();
				if (srchId == (id)) {
					System.out.println("Full Name is::" + perInfo.getFirstName() + " " + perInfo.getLastName());
					return;
				}
			}
			System.out.println("Data is not available");
		} else
			System.out.println("Data is not avilable");
	}

	
	/* Display the information of address book */
	public void display() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the book Name");
		String bookName = sc.next();

		hashMap = fileReader();
		LinkedList personInfo = (LinkedList) hashMap.get(bookName);
		if (personInfo != null && !personInfo.isEmpty()) {
			for (int i = 0; i < personInfo.size() ; i++) {
				Person informtion = (Person) personInfo.get(i);
				System.out.println("\n\n");
				System.out.println("|---------------|-------------------------|");
				System.out.println("| First Name   	|" + informtion.getFirstName());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| Last  Name   	|" + informtion.getLastName());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| Identity     	|" + informtion.getId());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| Phone  Name   |" +informtion.getPhone());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| City   Name   |" + informtion.getCity());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| State  Name   |" + informtion.getState());
				System.out.println("|---------------|-------------------------|");
				System.out.println("| zip code      |" + informtion.getZipCode());
				System.out.println("|---------------|-------------------------|");
				System.out.println("\n");
			}
		} else
			System.out.println("data is not found");
	}

	
	/* mobile number validation */
	boolean mobileNumeberValidation(String mobNum) {
		for (int i = 0; i < mobNum.length() && mobNum.length() == 10; i++) {
			if (mobNum.charAt(i) >= '0' && mobNum.charAt(i) <= '9')
				continue;
			else
				return false;
		}
		return mobNum.length() == 10;
	}

	
	/* Display name if present in any book */
	@Override
	public void display(String name) {
		
		hashMap = fileReader();
		Set<String> setKeys = hashMap.keySet();
		String keys[] = new String[setKeys.size()];
		int i = 0;

		if (setKeys != null) {

			for (String stringTemp : setKeys)
				keys[i++] = stringTemp;

			for (i = 0; i < keys.length; i++) {

				LinkedList linkedlist1 = (LinkedList) hashMap.get(keys[i]);

				if (linkedlist1 != null) {
					for (int j = 0; j < linkedlist1.size(); j++) {

						Person personInformation = (Person) linkedlist1.get(j);
						if (personInformation.getFirstName().equalsIgnoreCase(name)) {

							System.out.println("----------------------------------------");
							System.out.println(name + " present inside " + keys[i] + " address book");
							System.out.println("----------------------------------------");
							System.out.println("Id is a::" + personInformation.getId());
							System.out.println("First Name::" + personInformation.getFirstName());
							System.out.println("Last Name::" + personInformation.getLastName());
							System.out.println("Phone Number is::" + personInformation.getPhone());
							System.out.println("Address::" + personInformation.getAddress());
							System.out.println("City::" + personInformation.getCity());
							System.out.println("State is::" + personInformation.getState());
							System.out.println("zipcode is:" + personInformation.getZipCode());
						}
					}
				} else
					System.out.println("No data is avilable");
			}
		}
	}

	public HashMap fileReader() {
		HashMap h1 = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(Url.url + "Data.ser"));
			h1 = (HashMap) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return h1;
	}

	public void fileWriter() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(Url.url + "Data.ser");
			ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

			outObjectStream.writeObject(hashMap);
			outObjectStream.flush();
			outObjectStream.close();
			System.out.println("Successful");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
