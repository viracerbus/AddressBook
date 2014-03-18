package com.gac.edu.mcs270.hvidsten.shared;

import java.util.Comparator;

public class AddressBookEntry {

/*
 * Attributes	
 */
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private String email;
	private int phoneNumber;

/*
 * Constructors	
 */
	public AddressBookEntry() {}
	
	public AddressBookEntry(String firstName, String lastName, String address, String city, 
							String state, int zip, String email, int phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
/*
 * Getters and Setters	
 */
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
/*
 * Public Methods
 */
	public boolean isSearchInAddressBookEntry(String searchWord) {
		return this.getFirstName().equals(searchWord) || this.getLastName().equals(searchWord) || this.getAddress().equals(searchWord)
				|| this.getCity().equals(searchWord) || this.getState().equals(searchWord) || Integer.toString(this.getZip()).equals(searchWord)
				|| this.getEmail().equals(searchWord) || Integer.toString(this.getPhoneNumber()).equals(searchWord);
	}

/*
 * Comparators
 */
	public static Comparator<AddressBookEntry> COMPARE_BY_LASTNAME = new Comparator<AddressBookEntry>() {
        public int compare(AddressBookEntry one, AddressBookEntry other) {
            return one.lastName.compareTo(other.lastName);
        }
	};
	
	public static Comparator<AddressBookEntry> COMPARE_BY_ZIP = new Comparator<AddressBookEntry>() {
        public int compare(AddressBookEntry one, AddressBookEntry other) {
        	return Integer.compare(one.zip, other.zip);
        }
	};
}
