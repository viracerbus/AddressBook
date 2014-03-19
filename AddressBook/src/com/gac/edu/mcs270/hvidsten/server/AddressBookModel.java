package com.gac.edu.mcs270.hvidsten.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;

/**
 * Model for Address Book
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
public class AddressBookModel {

/*
 * Attributes
 */
	/**
	 * Persistence
	 */
	static final PersistenceManagerFactory pmf = PMF.get();

/*
 * Public Methods	
 */
	/**
	 * Gets the Address Book Entries from the persistence
	 * @return All Address Book Entries from the persistence
	 */
	public static List<AddressBookEntry> getAddressBookEntries() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressBookEntry.class);
		@SuppressWarnings("unchecked")
		List<AddressBookEntry> entries = (List<AddressBookEntry>) query.execute();
		return new ArrayList<AddressBookEntry>(entries);
	}
	
	/**
	 * Adds an Address Book Entry into the persistence
	 * @param newAddressBookEntry The Address Book Entry that is being added
	 */
	public static void addAddressBookEntry(AddressBookEntry newAddressBookEntry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(newAddressBookEntry);
	}
	
	/**
	 * Changes an Address Book Entry and saves the changes into the persistence
	 * @param changingAddressBookEntry The Address Book Entry that is being changed
	 * @param changes An Address Book Entry that holds the changes needed for the changingAddressBookEntry
	 */
	public static void editAddressBookEntry(AddressBookEntry changingAddressBookEntry, AddressBookEntry changes) {
		List<AddressBookEntry> entries = getAddressBookEntries();
		for(AddressBookEntry entry : entries) {
			if(entry.getId().equals(changingAddressBookEntry.getId())) {
				entry.setFirstName(changes.getFirstName());
				entry.setLastName(changes.getLastName());
				entry.setAddress(changes.getAddress());
				entry.setCity(changes.getCity());
				entry.setState(changes.getState());
				entry.setZip(changes.getZip());
				entry.setEmail(changes.getEmail());
				entry.setPhoneNumber(changes.getPhoneNumber());
			}
		}
	}
	
	/**
	 * Deletes an Address Book Entry from the persistence
	 * @param addressBookEntry
	 */
	public static void deleteAddressBookEntry(AddressBookEntry addressBookEntry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressBookEntry.class);
		@SuppressWarnings("unchecked")
		List<AddressBookEntry> entries = (List<AddressBookEntry>) query.execute();
		for(AddressBookEntry entry : entries) {
			if(entry.getId().equals(addressBookEntry.getId())) {
				pm.deletePersistent(entry);
			}
		}
			
	}
	
	/**
	 * Prints out all Address Book Entries from the persistence in mailing format
	 */
	public static void viewAllAddressBookEntries() {
		List<AddressBookEntry> entries = getAddressBookEntries();
		for(AddressBookEntry entry : entries) {
			System.out.println(entry.getFirstName() + " " + entry.getLastName());
			System.out.println(entry.getAddress());
			System.out.println(entry.getCity() + ", " + entry.getState() + " " + entry.getZip());
			if(entry.getPhoneNumber() == 10) {
				System.out.println("(" + Long.toString(entry.getPhoneNumber()).substring(0, 3) 
				+ ") " + Long.toString(entry.getPhoneNumber()).substring(3, 6) + "-" 
				+ Long.toString(entry.getPhoneNumber()).substring(6, 10));
			} else if (entry.getPhoneNumber() == 11){
				System.out.println(Long.toString(entry.getPhoneNumber()).substring(0, 1) + " (" 
				+ Long.toString(entry.getPhoneNumber()).substring(1, 4) + ") " 
				+ Long.toString(entry.getPhoneNumber()).substring(4, 7) + "-" 
				+ Long.toString(entry.getPhoneNumber()).substring(7, 11));
			}
			System.out.println(entry.getEmail());
		}
	}
	
	/**
	 * Searches the persistence for an entry with attributes that match the searchString
	 * @param searchString The string that is being compared to the attributes all Address Book Entries from the persistence
	 * @return All Address Book Entries that match the searchString
	 */
	public static List<AddressBookEntry> searchAddressBookEntries(String searchString) {
		List<AddressBookEntry> entries = getAddressBookEntries();
		List<AddressBookEntry> searchedEntries = new ArrayList<AddressBookEntry>();
		String[] searchStrings = searchString.split("\\s+"); // "\\s+" is a string of white space
		for(AddressBookEntry entry : entries) {
			for(String searchWord : searchStrings) {
				if(entry.isSearchInAddressBookEntry(searchWord)) {
					if(!searchedEntries.contains(entry)) {
						searchedEntries.add(entry);
					}
				}
			}
		}
		return searchedEntries;
	}

	/**
	 * Sorts all Address Book Entries from the persistence by last name
	 * @return All Address Book Entries sorted by last name
	 */
	public static List<AddressBookEntry> sortAddressBookEntriesByLastName() {
		List<AddressBookEntry> entries = getAddressBookEntries();
		Collections.sort(entries, AddressBookEntry.COMPARE_BY_LASTNAME);
		return entries;
	}
	
	/**
	 * Sorts all Address Book Entries from the persistence by zip code
	 * @return All Address Book Entries sorted by last zip code
	 */
	public static List<AddressBookEntry> sortAddressBookEntriesByZip() {
		List<AddressBookEntry> entries = getAddressBookEntries();
		Collections.sort(entries, AddressBookEntry.COMPARE_BY_ZIP);
		return entries;
	}
}
