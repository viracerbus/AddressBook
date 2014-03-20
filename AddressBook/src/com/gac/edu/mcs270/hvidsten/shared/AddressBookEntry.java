package com.gac.edu.mcs270.hvidsten.shared;

import java.io.Serializable;
import java.util.Comparator;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 *
 */
@SuppressWarnings("serial")
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class AddressBookEntry implements Serializable {

/*
 * Attributes	
 */
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String address;
	@Persistent
	private String city;
	@Persistent
	private String state;
	@Persistent
	private int zip;
	@Persistent
	private String email;
	@Persistent
	private Long phoneNumber;

/*
 * Constructors	
 */
	public AddressBookEntry() {}
	
	public AddressBookEntry(String firstName, String lastName, String address, String city, 
							String state, int zip, String email, Long phoneNumber) {
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
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
/*
 * Public Methods
 */
	/**
	 * Returns if a word is in an Address Book entry
	 * @param searchWord The word that is being compared to the attributes
	 * @return true if the searchWord is in an of the attributes and false if the searchWord is not
	 */
	public boolean isSearchInAddressBookEntry(String searchWord) {
		// Checks the search word against every attribute of the Address Book Entry
		return this.getFirstName().equals(searchWord) || this.getLastName().equals(searchWord) || this.getAddress().equals(searchWord)
				|| this.getCity().equals(searchWord) || this.getState().equals(searchWord) || Integer.toString(this.getZip()).equals(searchWord)
				|| this.getEmail().equals(searchWord) || Long.toString(this.getPhoneNumber()).equals(searchWord);
	}

/*
 * Comparators
 */
	/**
	 * Compares two Address Book Entries based on each entries last name
	 */
	public static Comparator<AddressBookEntry> COMPARE_BY_LASTNAME = new Comparator<AddressBookEntry>() {
        public int compare(AddressBookEntry one, AddressBookEntry other) {
            return one.lastName.compareTo(other.lastName);
        }
	};
	
	/**
	 * Compares two Address Book Entries based on each entries zip code
	 */
	public static Comparator<AddressBookEntry> COMPARE_BY_ZIP = new Comparator<AddressBookEntry>() {
        public int compare(AddressBookEntry one, AddressBookEntry other) {
        	return Integer.valueOf(one.zip).compareTo(Integer.valueOf(other.zip));
        }
	};

}
