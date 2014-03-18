package com.gac.edu.mcs270.hvidsten.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;

public class AddressBookModel {

/*
 * Attributes
 */
	static final PersistenceManagerFactory pmf = PMF.get();

/*
 * Public Methods	
 */
	public static List<AddressBookEntry> getAddressBookEntries() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressBookEntry.class);
		List<AddressBookEntry> entries = (List<AddressBookEntry>) query.execute();
		return new ArrayList<AddressBookEntry>(entries);
	}
	
	public static void addAddressBookEntry(AddressBookEntry newAddressBookEntry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(newAddressBookEntry);
	}
	
	public static void editAddressBookEntry(AddressBookEntry changingAddressBookEntry) {
		//TO DO IF TIME
	}
	
	public static void deleteAddressBookEntry(AddressBookEntry addressBookEntry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressBookEntry.class);
		List<AddressBookEntry> entries = (List<AddressBookEntry>) query.execute();
		pm.deletePersistent(addressBookEntry);
	}
	
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

	public static List<AddressBookEntry> sortAddressBookEntriesByLastName() {
		List<AddressBookEntry> entries = getAddressBookEntries();
		Collections.sort(entries, AddressBookEntry.COMPARE_BY_LASTNAME);
		return entries;
	}
	
	public static List<AddressBookEntry> sortAddressBookEntriesByZip() {
		List<AddressBookEntry> entries = getAddressBookEntries();
		Collections.sort(entries, AddressBookEntry.COMPARE_BY_ZIP);
		return entries;
	}
}
